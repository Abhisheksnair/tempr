package com.whatsapp.util.b;

import java.io.RandomAccessFile;

public final class b
{
  public static final b j = new b(1.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
  public static final b k = new b(0.0D, 1.0D, -1.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
  public static final b l = new b(-1.0D, 0.0D, 0.0D, -1.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
  public static final b m = new b(0.0D, -1.0D, 1.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
  double a;
  double b;
  double c;
  double d;
  double e;
  double f;
  double g;
  public double h;
  public double i;
  
  private b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9)
  {
    this.a = paramDouble5;
    this.b = paramDouble6;
    this.c = paramDouble7;
    this.d = paramDouble1;
    this.e = paramDouble2;
    this.f = paramDouble3;
    this.g = paramDouble4;
    this.h = paramDouble8;
    this.i = paramDouble9;
  }
  
  public static b a(RandomAccessFile paramRandomAccessFile)
  {
    double d1 = a.f(paramRandomAccessFile);
    double d2 = a.f(paramRandomAccessFile);
    double d3 = a.g(paramRandomAccessFile);
    double d4 = a.f(paramRandomAccessFile);
    double d5 = a.f(paramRandomAccessFile);
    double d6 = a.g(paramRandomAccessFile);
    double d7 = a.f(paramRandomAccessFile);
    double d8 = a.f(paramRandomAccessFile);
    return new b(d1, d2, d4, d5, d3, d6, a.g(paramRandomAccessFile), d7, d8);
  }
  
  public final int a()
  {
    if ((this.d == 0.0D) && (this.e == 1.0D) && (this.f == -1.0D) && (this.g == 0.0D)) {
      return 90;
    }
    if ((this.d == -1.0D) && (this.e == 0.0D) && (this.f == 0.0D) && (this.g == -1.0D)) {
      return 180;
    }
    if ((this.d == 0.0D) && (this.e == -1.0D) && (this.f == 1.0D) && (this.g == 0.0D)) {
      return 270;
    }
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (b)paramObject;
      if (Double.compare(((b)paramObject).d, this.d) != 0) {
        return false;
      }
      if (Double.compare(((b)paramObject).e, this.e) != 0) {
        return false;
      }
      if (Double.compare(((b)paramObject).f, this.f) != 0) {
        return false;
      }
      if (Double.compare(((b)paramObject).g, this.g) != 0) {
        return false;
      }
      if (Double.compare(((b)paramObject).h, this.h) != 0) {
        return false;
      }
      if (Double.compare(((b)paramObject).i, this.i) != 0) {
        return false;
      }
      if (Double.compare(((b)paramObject).a, this.a) != 0) {
        return false;
      }
      if (Double.compare(((b)paramObject).b, this.b) != 0) {
        return false;
      }
    } while (Double.compare(((b)paramObject).c, this.c) == 0);
    return false;
  }
  
  public final int hashCode()
  {
    long l1 = Double.doubleToLongBits(this.a);
    int n = (int)(l1 ^ l1 >>> 32);
    l1 = Double.doubleToLongBits(this.b);
    int i1 = (int)(l1 ^ l1 >>> 32);
    l1 = Double.doubleToLongBits(this.c);
    int i2 = (int)(l1 ^ l1 >>> 32);
    l1 = Double.doubleToLongBits(this.d);
    int i3 = (int)(l1 ^ l1 >>> 32);
    l1 = Double.doubleToLongBits(this.e);
    int i4 = (int)(l1 ^ l1 >>> 32);
    l1 = Double.doubleToLongBits(this.f);
    int i5 = (int)(l1 ^ l1 >>> 32);
    l1 = Double.doubleToLongBits(this.g);
    int i6 = (int)(l1 ^ l1 >>> 32);
    l1 = Double.doubleToLongBits(this.h);
    int i7 = (int)(l1 ^ l1 >>> 32);
    l1 = Double.doubleToLongBits(this.i);
    return (((((((n * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + (int)(l1 ^ l1 >>> 32);
  }
  
  public final String toString()
  {
    if (equals(j)) {
      return "Rotate 0°";
    }
    if (equals(k)) {
      return "Rotate 90°";
    }
    if (equals(l)) {
      return "Rotate 180°";
    }
    if (equals(m)) {
      return "Rotate 270°";
    }
    return "Matrix{u=" + this.a + ", v=" + this.b + ", w=" + this.c + ", a=" + this.d + ", b=" + this.e + ", c=" + this.f + ", d=" + this.g + ", tx=" + this.h + ", ty=" + this.i + '}';
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */