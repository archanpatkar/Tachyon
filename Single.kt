package com.archanpatkar.tachyon;

import java.net.*;
import java.io.*;

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
