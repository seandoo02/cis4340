/*NUM03_J Use integer types that can fully repersent the possible range of 
unigned data Given the non-compliant code below: */
public static int getInteger(DataInputStream is) throws IOException {
    return is.readInt(); 
  }

  /*Corrected Code*/
public static long getInteger(DataInputStream is) throws IOException {
    return is.readInt() & 0xFFFFFFFFL; // Mask with 32 one-bits
  }
