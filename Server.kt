package com.archanpatkar.tachyon;

import java.net.*;
import java.io.*;

fun main(args: Array<String>)
{
  val st1 = SerialTachyon(8081,10);
  st1.start { soc,nis,nos -> nos.println("hello from the other side!") }
}

interface Tachyon
{
  public fun start(cb: (soc:Socket,nis: BufferedReader,nos: PrintWriter) -> Unit);
}

class SerialTachyon: Tachyon
{
  private var ss:ServerSocket;
  private var maxConn:Int;

  public constructor(port: Int, maxConn:Int = 10)
  {
    this.ss = ServerSocket(port);
    this.maxConn = maxConn;
  }

  public override fun start(cb: (soc:Socket,nis: BufferedReader,nos: PrintWriter) -> Unit)
  {
    println("SerialTachyon Booting up!");
    val soc = ss.accept();
    val nis = BufferedReader(InputStreamReader(soc.getInputStream()));
    val nos = PrintWriter(BufferedWriter(OutputStreamWriter(soc.getOutputStream())), true);
    for(i in 1..maxConn)
    {
      println("Connection Established");
      cb(soc,nis,nos);
    }
    println("SerialTachyon Shutting Down");
  }
}
