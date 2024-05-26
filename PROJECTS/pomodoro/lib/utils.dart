import "package:flutter/material.dart";
import "package:google_fonts/google_fonts.dart";

TextStyle textStyle(double size, [Color? color, FontWeight? fw]){
  return GoogleFonts.roboto(
    fontSize:size,
    color: color,
    fontWeight: fw 
    );
}