package com.archanpatkar.tachyon;
import java.net.*;
import java.io.*;

public interface Tachyon
{
  public fun start(cb: (soc:Socket,nis: BufferedReader,nos: PrintWriter) -> Unit);
}
