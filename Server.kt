import java.net.*;
import java.io.*;
import com.archanpatkar.tachyon.SerialTachyon;

fun main(args: Array<String>)
{
  val st1 = SerialTachyon(8081,10);
  st1 start { soc,nis,nos ->
    nos.println("hello from the other side!")
  }
}
