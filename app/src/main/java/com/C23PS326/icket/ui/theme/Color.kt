package com.C23PS326.icket.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)


val Red = Color(0xFFD33030)
val Blue = Color(0xFF1697DF)
val Yellow = Color(0xFFECB21C)
val Pink = Color(0xFFF62A98)
val Green = Color(0xFF00C22B)
val Purple = Color(0xFFCC60FF)
val Darkpurple = Color(0xFFD715AC)
val LightBlue = Color(0xFF0657BD)

val Colors.redColor
get() = if (isLight) Red else Color.Red

val Colors.blueColor
get() = if (isLight) Blue else Color.Blue

val Colors.yellowColor
get() = if (isLight) Yellow else Color.Yellow

val Colors.pinkColor
get() = if (isLight) Pink else Color.Gray

val Colors.greenColor
get() = if(isLight) Green else Color.White

val Colors.purpleColor
get() = if(isLight) Purple else Color.LightGray

val Colors.darkpurpleColor
get() = if(isLight) Darkpurple else Color.White

val Colors.lightblue
get() = if(isLight) LightBlue else Color.White