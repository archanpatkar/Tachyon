package com.archanpatkar.tachyon;

import java.net.*;
import java.io.*;

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
