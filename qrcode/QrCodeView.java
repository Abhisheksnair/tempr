package com.whatsapp.qrcode;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.whatsapp.camera.CameraView;
import com.whatsapp.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QrCodeView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  SurfaceHolder a = getHolder();
  Camera b;
  Handler c;
  final Camera.AutoFocusCallback d = new Camera.AutoFocusCallback()
  {
    public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
    {
      Log.d("qrview/onAutoFocus " + paramAnonymousBoolean);
      paramAnonymousCamera = i.a(this);
      if (QrCodeView.a(QrCodeView.this) != null)
      {
        QrCodeView.a(QrCodeView.this).postDelayed(paramAnonymousCamera, 2000L);
        return;
      }
      QrCodeView.this.postDelayed(paramAnonymousCamera, 2000L);
    }
  };
  private Camera.Size e;
  private a f;
  
  public QrCodeView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QrCodeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QrCodeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.addCallback(this);
    this.a.setType(3);
  }
  
  final void a()
  {
    if (this.b != null) {
      return;
    }
    try
    {
      this.b = Camera.open();
      if (this.b == null) {
        this.b = Camera.open(0);
      }
      this.b.setErrorCallback(g.a(this));
      return;
    }
    catch (Exception localException)
    {
      if (this.b != null) {
        this.b.release();
      }
      this.b = null;
      Log.d("qrview/startcamera error opening camera", localException);
      a(1);
    }
  }
  
  final void a(int paramInt)
  {
    if (this.f != null) {
      this.f.a(paramInt);
    }
  }
  
  final void b()
  {
    if (this.b == null)
    {
      if (this.c != null)
      {
        this.c.post(h.a(this));
        return;
      }
      a();
      return;
    }
    try
    {
      this.b.reconnect();
      return;
    }
    catch (IOException localIOException)
    {
      this.b.release();
      this.b = null;
      Log.d("qrview/startcamera error reconnecting camera", localIOException);
      a(1);
    }
  }
  
  final void c()
  {
    Log.i("qrview/stopcamera");
    if (this.b != null) {}
    try
    {
      this.b.stopPreview();
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.b.release();
          this.b = null;
          return;
          localException1 = localException1;
          Log.c("qrview/stopcamera error stopping camera preview", localException1);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.c("qrview/stopcamera error releaseing camera", localException2);
        }
      }
    }
  }
  
  final void d()
  {
    boolean bool = true;
    int n = 0;
    int i = getWidth();
    int j = getHeight();
    Log.d("qrview/startpreview " + i + "x" + j);
    if (this.b == null)
    {
      Log.e("qrview/startpreview camera is null");
      a(1);
      return;
    }
    int i1 = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getOrientation();
    int m;
    label98:
    Camera.Parameters localParameters;
    Object localObject;
    if ((i1 == 0) || (i1 == 2))
    {
      m = 1;
      localParameters = this.b.getParameters();
      localObject = localParameters.getSupportedPreviewSizes();
      if (localObject != null) {
        break label720;
      }
      Log.i("qrview/fallbacksupportedpreviewsizes");
      localObject = new ArrayList();
      Camera localCamera = this.b;
      localCamera.getClass();
      ((List)localObject).add(new Camera.Size(localCamera, 640, 480));
    }
    label175:
    label180:
    label255:
    label299:
    label579:
    label584:
    label711:
    label720:
    for (;;)
    {
      int k;
      if (m != 0)
      {
        k = j;
        if (m == 0) {
          break label579;
        }
        this.e = CameraView.a((List)localObject, k, i);
        Log.i("qrview/startpreview optimal preview size:" + this.e.width + "x" + this.e.height);
        localObject = new Camera.CameraInfo();
        Camera.getCameraInfo(0, (Camera.CameraInfo)localObject);
        if (((Camera.CameraInfo)localObject).facing != 1) {
          break label584;
        }
        k = ((Camera.CameraInfo)localObject).orientation;
        i = n;
        switch (i1)
        {
        default: 
          i = n;
        case 0: 
          if (bool)
          {
            j = (360 - (k + i) % 360) % 360;
            Log.i("qrview/startpreview display:" + i + " camera:" + k + " preview:" + j + " front:" + bool);
          }
          break;
        }
      }
      try
      {
        this.b.setDisplayOrientation(j);
        localParameters.setPreviewSize(this.e.width, this.e.height);
        localObject = localParameters.getSupportedFocusModes();
        if (localObject != null)
        {
          Log.i("qrview/startpreview supported focus:" + Arrays.deepToString(((List)localObject).toArray()));
          if (((List)localObject).contains("auto"))
          {
            localParameters.setFocusMode("auto");
            localObject = localParameters.getSupportedFlashModes();
            if (localObject == null) {
              break label711;
            }
            Log.i("qrview/startpreview supported flash:" + Arrays.deepToString(((List)localObject).toArray()));
            if ((localObject != null) && (((List)localObject).contains("off"))) {
              localParameters.setFlashMode("off");
            }
            this.b.setParameters(localParameters);
            this.b.startPreview();
            this.b.autoFocus(this.d);
            if (this.f == null) {
              break;
            }
            this.f.a();
            return;
            m = 0;
            break label98;
            k = i;
            break label175;
            i = j;
            break label180;
            bool = false;
            break label255;
            i = 90;
            break label299;
            i = 180;
            break label299;
            i = 270;
            break label299;
            j = (k - i + 360) % 360;
          }
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          Log.e("qrview/startpreview/setdisplayorientation " + localRuntimeException.toString());
          continue;
          if (localRuntimeException.contains("macro"))
          {
            localParameters.setFocusMode("macro");
          }
          else if (localRuntimeException.contains("edof"))
          {
            localParameters.setFocusMode("edof");
            continue;
            Log.i("qrview/startpreview supported focus:null");
            continue;
            Log.i("qrview/startpreview supported flash:null");
          }
        }
      }
    }
  }
  
  public Camera getCamera()
  {
    return this.b;
  }
  
  public Camera.Size getPreviewSize()
  {
    return this.e;
  }
  
  public void setCameraCallback(a parama)
  {
    this.f = parama;
  }
  
  public void setThreadHandler(Handler paramHandler)
  {
    this.c = paramHandler;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.b == null)
    {
      if (this.c == null)
      {
        Log.e("qrview/surfacechanged: no camera");
        a(1);
      }
      return;
    }
    if (this.a.getSurface() == null)
    {
      Log.e("qrview/surfacechanged: no surface");
      a(1);
      return;
    }
    Log.d("qrview/surfacechanged  format:" + paramInt1 + " w:" + paramInt2 + " h:" + paramInt3);
    try
    {
      if (!paramSurfaceHolder.isCreating())
      {
        Log.d("qrview/surfacechanged: !holder.isCreating");
        this.b.stopPreview();
      }
      this.b.setPreviewDisplay(paramSurfaceHolder);
      d();
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      this.b.release();
      this.b = null;
      Log.d("qrview/surfacechanged ", paramSurfaceHolder);
      a(1);
      return;
    }
    catch (IOException paramSurfaceHolder)
    {
      this.b.release();
      this.b = null;
      Log.d("qrview/surfacechanged: error setting preview display", paramSurfaceHolder);
      a(1);
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    Log.i("qrview/surfaceCreated");
    b();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    Log.i("qrview/surfacedestroyed");
    c();
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/qrcode/QrCodeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */