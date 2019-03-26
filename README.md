# <img src="./TACHYON.png">
### An Instantiable Server Framework in Kotlin

## Introduction
A Tachyon is an instantiable unit server. 
This library provides three types of Tachyons -
> Every Tachyon has one thread which handles connection requests but the nature of that thread changes from Tachyon to Tachyon

| Tachyon    	| Nature       	|
|------------	|--------------	|
| Single     	| Single      	|
| Serial     	| Blocking ( will Block Clients )     	|
| Concurrent 	| Non Blocking ( will accept arbitary clients without blocking them )	|

## Example Usage

#### `SingleTachyon`
```kotlin
import java.net.*;
import java.io.*;
import com.archanpatkar.tachyon.SingleTachyon;

fun main(args: Array<String>)
{
  val st1 = SingalTachyon(8081); // Port Number
  st1 start { soc,nis,nos ->
    nos.println("hello from the other side!")
  }
}
```

#### `SerialTachyon`
```kotlin
import java.net.*;
import java.io.*;
import com.archanpatkar.tachyon.SerialTachyon;

fun main(args: Array<String>)
{
  val set1 = SerialTachyon(8081,10); // Port Number , Number of Connections
  set1 start { soc,nis,nos ->
    nos.println("hello from the other side!")
  }
}
```

#### `ConcurrentTachyon`
```kotlin
import java.net.*;
import java.io.*;
import com.archanpatkar.tachyon.ConcurrentTachyon;

fun main(args: Array<String>)
{
  val ct1 = ConcurrentTachyon(8081); // Port Number
  ct1 start { soc,nis,nos ->
    nos.println("hello from the other side!")
  }
}
```
