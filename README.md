# <img src="./TACHYON.png">
### A Instantiable Server Framework in Kotlin

## Introduction
An Tachyon is an instantiable unit server. 
This library provides three types of Tachyons.

| Tachyon    	| Nature       	|
|------------	|--------------	|
| Single     	| Blocking     	|
| Serial     	| Blocking     	|
| Concurrent 	| Non Blocking 	|

## Example Usage

#### `SingleTachyon`
```kotlin
import java.net.*;
import java.io.*;
import com.archanpatkar.tachyon.SerialTachyon;

fun main(args: Array<String>)
{
  val st1 = SingalTachyon(8081);
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
  val st1 = SerialTachyon(8081,10);
  st1 start { soc,nis,nos ->
    nos.println("hello from the other side!")
  }
}
```

#### `ConcurrentTachyon`
```kotlin
import java.net.*;
import java.io.*;
import com.archanpatkar.tachyon.SerialTachyon;

fun main(args: Array<String>)
{
  val ct1 = ConcurrentTachyon(8081);
  ct1 start { soc,nis,nos ->
    nos.println("hello from the other side!")
  }
}
```
