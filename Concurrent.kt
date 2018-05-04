package com.archanpatkar.tachyon;

import java.net.*;
import java.io.*;
import kotlin.concurrent.thread;

public class ConcurrentTachyon: Tachyon
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
    println("ConcurrentTachyon Booting up!");
    println("ConcurrentTachyon waiting on PORT:$port");
    while(true)
    {
      val soc = ss.accept();
      println("Connection Established");
      val nis = BufferedReader(InputStreamReader(soc.getInputStream()));
      val nos = PrintWriter(BufferedWriter(OutputStreamWriter(soc.getOutputStream())), true);
      thread {
        cb(soc,nis,nos);
      }
    }
    println("ConcurrentTachyon Shutting Down");
  }
}
