package com.archanpatkar.tachyon;

import java.net.*;
import java.io.*;

fun main(args: Array<String>)
{
  val st1 = SerialTachyon(8081,10);
  st1 start { soc,nis,nos ->
    nos.println("hello from the other side!")
  }
}

interface Tachyon
{
  public fun start(cb: (soc:Socket,nis: BufferedReader,nos: PrintWriter) -> Unit);
}

class SingleTachyon: Tachyon
{
  private var ss:ServerSocket;
  private var port:Int;

  public constructor(port: Int)
  {
    this.port = port;
    this.ss = ServerSocket(port);
  }

  public infix override fun start(cb: (soc:Socket,nis: BufferedReader,nos: PrintWriter) -> Unit)
  {
    println("SingleTachyon Booting up!");
    println("SingleTachyon waiting on PORT:$port");
    val soc = ss.accept();
    println("Connection Established");
    val nis = BufferedReader(InputStreamReader(soc.getInputStream()));
    val nos = PrintWriter(BufferedWriter(OutputStreamWriter(soc.getOutputStream())), true);
    cb(soc,nis,nos);
    println("SingleTachyon Shutting Down");
  }
}

class SerialTachyon: Tachyon
{
  private var ss:ServerSocket;
  private var port:Int;
  private var maxConn:Int;

  public constructor(port: Int, maxConn:Int = 10)
  {
    this.ss = ServerSocket(port);
    this.port = port;
    this.maxConn = maxConn;
  }

  public infix override fun start(cb: (soc:Socket,nis: BufferedReader,nos: PrintWriter) -> Unit)
  {
    println("SerialTachyon Booting up!");
    println("SerialTachyon waiting on PORT:$port");
    for(i in 1..maxConn)
    {
      val soc = ss.accept();
      println("Connection Established");
      val nis = BufferedReader(InputStreamReader(soc.getInputStream()));
      val nos = PrintWriter(BufferedWriter(OutputStreamWriter(soc.getOutputStream())), true);
      cb(soc,nis,nos);
    }
    println("SerialTachyon Shutting Down");
  }
}

class ConncurrentTachyon: Tachyon
{
  public infix override fun start(cb: (soc:Socket,nis: BufferedReader,nos: PrintWriter) -> Unit)
  {
    
  }
}
