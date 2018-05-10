import java.net.*;
import java.io.*;
import com.archanpatkar.tachyon.ConcurrentTachyon;

fun main(args: Array<String>)
{
  val st1 = ConcurrentTachyon(8081);// Port
  st1 start { soc,nis,nos ->
    nos.println("hello from the other side!")
  }
}
