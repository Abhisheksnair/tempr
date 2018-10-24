package com.whatsapp;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

final class aqd
{
  FloatBuffer a = ByteBuffer.allocateDirect(this.j.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
  float[] b = new float[16];
  float[] c = new float[16];
  int d;
  int e = 53191;
  int f;
  int g;
  int h;
  int i;
  private final float[] j = { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  
  public aqd()
  {
    this.a.put(this.j).position(0);
    Matrix.setIdentityM(this.c, 0);
  }
  
  static int a(int paramInt, String paramString)
  {
    int k = GLES20.glCreateShader(paramInt);
    a("glCreateShader type=" + paramInt);
    GLES20.glShaderSource(k, paramString);
    GLES20.glCompileShader(k);
    paramString = new int[1];
    GLES20.glGetShaderiv(k, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      Log.e("TextureRender", "Could not compile shader " + paramInt + ":");
      Log.e("TextureRender", " " + GLES20.glGetShaderInfoLog(k));
      GLES20.glDeleteShader(k);
      return 0;
    }
    return k;
  }
  
  public static void a(String paramString)
  {
    int k = GLES20.glGetError();
    if (k != 0)
    {
      Log.e("TextureRender", paramString + ": glError " + k);
      throw new RuntimeException(paramString + ": glError " + k);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aqd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */