package com.whatsapp;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class aqc
  implements SurfaceTexture.OnFrameAvailableListener
{
  SurfaceTexture a;
  Surface b;
  aqd c;
  private EGL10 d;
  private EGLDisplay e;
  private EGLContext f;
  private EGLSurface g;
  private Object h = new Object();
  private boolean i;
  
  public aqc()
  {
    c();
  }
  
  public aqc(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException();
    }
    this.d = ((EGL10)EGLContext.getEGL());
    this.e = this.d.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (!this.d.eglInitialize(this.e, null)) {
      throw new RuntimeException("unable to initialize EGL10");
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    if (!this.d.eglChooseConfig(this.e, new int[] { 12324, 8, 12323, 8, 12322, 8, 12339, 1, 12352, 4, 12344 }, arrayOfEGLConfig, 1, arrayOfInt)) {
      throw new RuntimeException("unable to find RGB888+pbuffer EGL config");
    }
    this.f = this.d.eglCreateContext(this.e, arrayOfEGLConfig[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    a("eglCreateContext");
    if (this.f == null) {
      throw new RuntimeException("null context");
    }
    this.g = this.d.eglCreatePbufferSurface(this.e, arrayOfEGLConfig[0], new int[] { 12375, paramInt1, 12374, paramInt2, 12344 });
    a("eglCreatePbufferSurface");
    if (this.g == null) {
      throw new RuntimeException("surface was null");
    }
    a();
    c();
  }
  
  private void a(String paramString)
  {
    for (int j = 0;; j = 1)
    {
      int k = this.d.eglGetError();
      if (k == 12288) {
        break;
      }
      Log.e("OutputSurface", paramString + ": EGL error: 0x" + Integer.toHexString(k));
    }
    if (j != 0) {
      throw new RuntimeException("EGL error encountered (see log)");
    }
  }
  
  private void c()
  {
    this.c = new aqd();
    aqd localaqd = this.c;
    int j = aqd.a(35633, "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n");
    if (j == 0) {
      j = 0;
    }
    for (;;)
    {
      localaqd.d = j;
      if (localaqd.d != 0) {
        break;
      }
      throw new RuntimeException("failed creating program");
      int m = aqd.a(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
      if (m == 0)
      {
        j = 0;
      }
      else
      {
        int k = GLES20.glCreateProgram();
        aqd.a("glCreateProgram");
        if (k == 0) {
          Log.e("TextureRender", "Could not create program");
        }
        GLES20.glAttachShader(k, j);
        aqd.a("glAttachShader");
        GLES20.glAttachShader(k, m);
        aqd.a("glAttachShader");
        GLES20.glLinkProgram(k);
        arrayOfInt = new int[1];
        GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
        j = k;
        if (arrayOfInt[0] != 1)
        {
          Log.e("TextureRender", "Could not link program: ");
          Log.e("TextureRender", GLES20.glGetProgramInfoLog(k));
          GLES20.glDeleteProgram(k);
          j = 0;
        }
      }
    }
    localaqd.h = GLES20.glGetAttribLocation(localaqd.d, "aPosition");
    aqd.a("glGetAttribLocation aPosition");
    if (localaqd.h == -1) {
      throw new RuntimeException("Could not get attrib location for aPosition");
    }
    localaqd.i = GLES20.glGetAttribLocation(localaqd.d, "aTextureCoord");
    aqd.a("glGetAttribLocation aTextureCoord");
    if (localaqd.i == -1) {
      throw new RuntimeException("Could not get attrib location for aTextureCoord");
    }
    localaqd.f = GLES20.glGetUniformLocation(localaqd.d, "uMVPMatrix");
    aqd.a("glGetUniformLocation uMVPMatrix");
    if (localaqd.f == -1) {
      throw new RuntimeException("Could not get attrib location for uMVPMatrix");
    }
    localaqd.g = GLES20.glGetUniformLocation(localaqd.d, "uSTMatrix");
    aqd.a("glGetUniformLocation uSTMatrix");
    if (localaqd.g == -1) {
      throw new RuntimeException("Could not get attrib location for uSTMatrix");
    }
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    localaqd.e = arrayOfInt[0];
    GLES20.glBindTexture(36197, localaqd.e);
    aqd.a("glBindTexture mTextureID");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    aqd.a("glTexParameter");
    this.a = new SurfaceTexture(this.c.e);
    this.a.setOnFrameAvailableListener(this);
    this.b = new Surface(this.a);
  }
  
  public final void a()
  {
    if (this.d == null) {
      throw new RuntimeException("not configured for makeCurrent");
    }
    a("before makeCurrent");
    if (!this.d.eglMakeCurrent(this.e, this.g, this.g, this.f)) {
      throw new RuntimeException("eglMakeCurrent failed");
    }
  }
  
  public final void b()
  {
    synchronized (this.h)
    {
      for (;;)
      {
        boolean bool = this.i;
        if (!bool) {
          try
          {
            this.h.wait(500L);
            if (!this.i) {
              throw new RuntimeException("Surface frame wait timed out");
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            throw new RuntimeException(localInterruptedException);
          }
        }
      }
    }
    this.i = false;
    aqd.a("before updateTexImage");
    this.a.updateTexImage();
  }
  
  public final void onFrameAvailable(SurfaceTexture arg1)
  {
    synchronized (this.h)
    {
      if (this.i) {
        throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
      }
    }
    this.i = true;
    this.h.notifyAll();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aqc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */