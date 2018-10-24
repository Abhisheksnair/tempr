package com.whatsapp;

import com.whatsapp.a.c;
import com.whatsapp.messaging.m;

public class bg
{
  private static volatile bg c;
  final m a;
  final c b;
  
  private bg(m paramm, c paramc)
  {
    this.a = paramm;
    this.b = paramc;
  }
  
  public static bg a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new bg(m.a(), c.a());
      }
      return c;
    }
    finally {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */