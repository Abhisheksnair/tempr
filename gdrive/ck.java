package com.whatsapp.gdrive;

import java.util.Comparator;
import java.util.regex.Pattern;

final class ck
  implements Comparator<String>
{
  private static final Pattern a = Pattern.compile(".*(\\d\\d\\d\\d\\d\\d\\d\\d).*");
  private static final Pattern b = Pattern.compile("WA(\\d\\d\\d\\d)");
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */