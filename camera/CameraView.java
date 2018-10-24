package com.whatsapp.camera;

import a.a.a.a.d;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.view.g;
import android.util.AttributeSet;
import android.view.Display;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.whatsapp.atu;
import com.whatsapp.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CameraView
  extends SurfaceView
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, SurfaceHolder.Callback
{
  private static final String[] y = { "GT-I9505", "GT-I9506", "GT-I9505G", "SGH-I337", "SGH-M919", "SCH-I545", "SPH-L720", "SCH-R970", "GT-I9508", "SGH-N045", "SC-04E" };
  private static final String[] z = { "GT-I9195", "GT-I9190", "GT-I9192" };
  SurfaceHolder a;
  Camera b;
  public boolean c;
  boolean d;
  boolean e;
  a f;
  boolean g;
  private int h;
  private String i;
  private MediaRecorder j;
  private Camera.Size k;
  private Camera.Size l;
  private List<Camera.Size> m;
  private ScaleGestureDetector n;
  private g o;
  private float p = 1.0F;
  private b q;
  private Display r;
  private int s;
  private int t;
  private HandlerThread u;
  private Handler v;
  private final Handler w = new Handler(Looper.getMainLooper());
  private final atu x;
  
  public CameraView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode()) {}
    for (paramAttributeSet = null;; paramAttributeSet = atu.a())
    {
      this.x = paramAttributeSet;
      paramAttributeSet = paramContext.getSharedPreferences("com.whatsapp_preferences", 0);
      this.h = paramAttributeSet.getInt("camera_index", 0);
      this.i = paramAttributeSet.getString("flash_mode", null);
      this.a = getHolder();
      this.a.addCallback(this);
      this.a.setType(3);
      this.o = new g(paramContext, this);
      this.n = new ScaleGestureDetector(paramContext, this);
      this.r = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      this.q = new b(paramContext);
      return;
    }
  }
  
  public static Camera.Size a(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    double d1 = paramInt1 / paramInt2;
    if (paramList == null)
    {
      localObject1 = null;
      return (Camera.Size)localObject1;
    }
    Object localObject1 = null;
    Iterator localIterator = paramList.iterator();
    label27:
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (Camera.Size)localIterator.next();
      double d2 = ((Camera.Size)localObject2).width / ((Camera.Size)localObject2).height;
      double d3 = ((Camera.Size)localObject2).width / paramInt1;
      if ((((Camera.Size)localObject2).width * ((Camera.Size)localObject2).height >= 153600) && (d3 <= 1.5D) && (Math.abs(d2 - d1) <= 0.1D))
      {
        if (!a((Camera.Size)localObject2, (Camera.Size)localObject1, paramInt1, paramInt2)) {
          break label275;
        }
        localObject1 = localObject2;
      }
    }
    label275:
    for (;;)
    {
      break label27;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localIterator = paramList.iterator();
        for (;;)
        {
          localObject2 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = (Camera.Size)localIterator.next();
          if ((((Camera.Size)localObject2).width / paramInt1 <= 1.5D) && (a((Camera.Size)localObject2, (Camera.Size)localObject1, paramInt1, paramInt2))) {
            localObject1 = localObject2;
          }
        }
      }
      if (localObject2 == null)
      {
        localIterator = paramList.iterator();
        paramList = (List<Camera.Size>)localObject2;
        localObject1 = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (Camera.Size)localIterator.next();
        if (a((Camera.Size)localObject1, paramList, paramInt1, paramInt2)) {
          paramList = (List<Camera.Size>)localObject1;
        }
        for (;;)
        {
          break;
        }
      }
      return (Camera.Size)localObject2;
    }
  }
  
  private static String a(List<Camera.Size> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Camera.Size localSize = (Camera.Size)paramList.next();
      localStringBuilder.append(localSize.width).append('x').append(localSize.height).append(", ");
    }
    if (localStringBuilder.length() > 1) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 2);
    }
    return localStringBuilder.toString();
  }
  
  private static boolean a(Camera.Size paramSize1, Camera.Size paramSize2, int paramInt1, int paramInt2)
  {
    if (paramSize2 == null) {}
    int i1;
    int i2;
    int i3;
    do
    {
      return true;
      i1 = Math.abs(paramSize2.height - paramInt2);
      i2 = Math.abs(paramSize1.height - paramInt2);
      i3 = Math.abs(paramSize2.width - paramInt1);
    } while (i2 * paramInt1 + Math.abs(paramSize1.width - paramInt1) * paramInt2 < i1 * paramInt1 + i3 * paramInt2);
    return false;
  }
  
  private boolean b(File paramFile, int paramInt)
  {
    Log.i("cameraview/prepare-video front:" + this.g);
    this.j = new MediaRecorder();
    CamcorderProfile localCamcorderProfile;
    if (Build.VERSION.SDK_INT >= 11) {
      if (CamcorderProfile.hasProfile(this.h, 4)) {
        localCamcorderProfile = CamcorderProfile.get(this.h, 4);
      }
    }
    while (localCamcorderProfile == null)
    {
      Log.e("cameraview/ no profile");
      return false;
      if (CamcorderProfile.hasProfile(this.h, 5))
      {
        localCamcorderProfile = CamcorderProfile.get(this.h, 5);
      }
      else
      {
        localCamcorderProfile = CamcorderProfile.get(this.h, 1);
        continue;
        localCamcorderProfile = CamcorderProfile.get(this.h, 1);
      }
    }
    Log.i("cameraview/prepare-video profile:" + localCamcorderProfile.videoFrameWidth + "x" + localCamcorderProfile.videoFrameHeight + " videoCodec:" + localCamcorderProfile.videoCodec + " audioCodec:" + localCamcorderProfile.audioCodec + " fileFormat:" + localCamcorderProfile.fileFormat + " videoFrameRate:" + localCamcorderProfile.videoFrameRate + " videoBitRate:" + localCamcorderProfile.videoBitRate);
    Camera.Parameters localParameters = this.b.getParameters();
    Object localObject4 = localParameters.getSupportedPreviewSizes();
    if (localObject4 == null) {
      localObject4 = getFallbackSupportedPreviewSizes();
    }
    for (;;)
    {
      Object localObject1 = null;
      if (Build.VERSION.SDK_INT >= 11) {
        localObject1 = localParameters.getSupportedVideoSizes();
      }
      if (localObject1 == null) {
        localObject1 = localObject4;
      }
      for (;;)
      {
        if ((localObject1 == null) || (((List)localObject1).isEmpty()))
        {
          Log.e("cameraview/prepare-video no supported video sizes");
          return false;
        }
        Object localObject3;
        int i1;
        if (Build.VERSION.SDK_INT >= 11)
        {
          localObject3 = localParameters.getPreferredPreviewSizeForVideo();
          if (localObject3 != null)
          {
            Log.i("cameraview/prepare-video preferred video preview size:" + ((Camera.Size)localObject3).width + "x" + ((Camera.Size)localObject3).height);
            if ((((Camera.Size)localObject3).width == 176) && (((Camera.Size)localObject3).height == 144)) {
              break label594;
            }
            i1 = ((Camera.Size)localObject3).width * ((Camera.Size)localObject3).height;
          }
        }
        for (;;)
        {
          Log.i("cameraview/prepare-video supported video sizes:" + a((List)localObject1));
          Collections.sort((List)localObject1, x.a());
          Log.i("cameraview/prepare-video supported preview sizes:" + a((List)localObject4));
          double d1 = Double.MAX_VALUE;
          double d3 = this.k.width / this.k.height;
          Object localObject6 = ((List)localObject1).iterator();
          localObject1 = null;
          Object localObject5;
          double d2;
          for (;;)
          {
            if (((Iterator)localObject6).hasNext())
            {
              localObject5 = (Camera.Size)((Iterator)localObject6).next();
              if ((((Camera.Size)localObject5).width <= 1280) && (((Camera.Size)localObject5).width >= 320) && ((Build.VERSION.SDK_INT > 16) || (((Camera.Size)localObject5).width <= 720)))
              {
                d2 = ((Camera.Size)localObject5).width / ((Camera.Size)localObject5).height;
                if (localObject1 == null)
                {
                  d1 = d2;
                  localObject1 = localObject5;
                  continue;
                  Log.w("cameraview/prepare-video preferred video preview size is null");
                  label594:
                  i1 = Integer.MAX_VALUE;
                  break;
                }
                if (Math.abs(d3 - d2) >= Math.abs(d3 - d1)) {
                  break label1941;
                }
                d1 = d2;
                localObject1 = localObject5;
              }
            }
          }
          label1776:
          label1921:
          label1941:
          for (;;)
          {
            break;
            if (localObject1 == null)
            {
              Log.e("cameraview/prepare-video cannot find video size");
              return false;
            }
            localObject6 = ((List)localObject4).iterator();
            do
            {
              if (!((Iterator)localObject6).hasNext()) {
                break;
              }
              localObject5 = (Camera.Size)((Iterator)localObject6).next();
            } while (!((Camera.Size)localObject1).equals(localObject5));
            for (;;)
            {
              if ((this.g) && (Build.VERSION.SDK_INT >= 17) && (Build.VERSION.SDK_INT <= 19) && ("samsung".equals(Build.MANUFACTURER)) && (d.a(y, Build.MODEL)))
              {
                localObject1 = this.b;
                localObject1.getClass();
                localObject1 = new Camera.Size((Camera)localObject1, 1440, 1080);
                localObject5 = this.b;
                localObject5.getClass();
                localObject6 = new Camera.Size((Camera)localObject5, 640, 480);
              }
              for (;;)
              {
                localObject5 = localObject1;
                Iterator localIterator;
                if (localObject1 == null)
                {
                  d1 = Double.MAX_VALUE;
                  d3 = ((Camera.Size)localObject6).width / ((Camera.Size)localObject6).height;
                  localIterator = ((List)localObject4).iterator();
                  while (localIterator.hasNext())
                  {
                    localObject5 = (Camera.Size)localIterator.next();
                    if ((((Camera.Size)localObject5).width < ((Camera.Size)localObject6).width) || (((Camera.Size)localObject5).height < ((Camera.Size)localObject6).height) || (((Camera.Size)localObject5).height * ((Camera.Size)localObject5).width > i1)) {
                      break label1921;
                    }
                    d2 = ((Camera.Size)localObject5).width / ((Camera.Size)localObject5).height;
                    if (localObject1 == null)
                    {
                      d1 = d2;
                      localObject1 = localObject5;
                    }
                    else
                    {
                      if (Math.abs(d3 - d2) >= Math.abs(d3 - d1)) {
                        break label1921;
                      }
                      d1 = d2;
                      localObject1 = localObject5;
                    }
                  }
                }
                for (;;)
                {
                  break;
                  localObject5 = localObject1;
                  if (localObject1 == null)
                  {
                    Log.i("cameraview/prepare-video cannot find preview size that is larger than video");
                    localIterator = ((List)localObject4).iterator();
                    for (;;)
                    {
                      localObject5 = localObject1;
                      if (!localIterator.hasNext()) {
                        break;
                      }
                      localObject4 = (Camera.Size)localIterator.next();
                      if (((Camera.Size)localObject4).height * ((Camera.Size)localObject4).width <= i1)
                      {
                        d2 = ((Camera.Size)localObject4).width / ((Camera.Size)localObject4).height;
                        if (localObject1 == null)
                        {
                          d1 = d2;
                          localObject1 = localObject4;
                        }
                        else if (Math.abs(d3 - d2) < Math.abs(d3 - d1))
                        {
                          d1 = d2;
                          localObject1 = localObject4;
                        }
                      }
                    }
                  }
                  localObject1 = localObject5;
                  localObject5 = localObject1;
                  if (localObject1 == null) {
                    Log.i("cameraview/prepare-video use preferred video size");
                  }
                  for (;;)
                  {
                    if (localObject3 == null)
                    {
                      Log.e("cameraview/prepare-video cannot find preview size");
                      return false;
                    }
                    localCamcorderProfile.videoFrameWidth = ((Camera.Size)localObject6).width;
                    localCamcorderProfile.videoFrameHeight = ((Camera.Size)localObject6).height;
                    localCamcorderProfile.videoBitRate = (localCamcorderProfile.videoFrameWidth * localCamcorderProfile.videoFrameHeight << 2);
                    Log.i("cameraview/prepare-video use profile:" + localCamcorderProfile.videoFrameWidth + "x" + localCamcorderProfile.videoFrameHeight + " videoBitRate:" + localCamcorderProfile.videoBitRate + " preview:" + ((Camera.Size)localObject3).width + "x" + ((Camera.Size)localObject3).height);
                    localParameters.set("cam_mode", 1);
                    localObject1 = localParameters.getSupportedFocusModes();
                    if (localObject1 != null)
                    {
                      Log.i("cameraview/prepare-video supported focus:" + Arrays.deepToString(((List)localObject1).toArray()));
                      if (((List)localObject1).contains("continuous-video")) {
                        localParameters.setFocusMode("continuous-video");
                      }
                    }
                    for (;;)
                    {
                      d1 = Math.min(Math.abs(this.k.width / this.k.height - ((Camera.Size)localObject3).width / ((Camera.Size)localObject3).height), Math.abs(this.k.height / this.k.width - ((Camera.Size)localObject3).width / ((Camera.Size)localObject3).height));
                      this.l = this.k;
                      if (d1 > 0.1D)
                      {
                        i1 = 1;
                        if (i1 != 0)
                        {
                          Log.i("cameraview/prepare-video restart preview for video");
                          localParameters.setPreviewSize(((Camera.Size)localObject3).width, ((Camera.Size)localObject3).height);
                          this.l = ((Camera.Size)localObject3);
                          this.b.stopPreview();
                          this.e = false;
                        }
                        if ("on".equals(this.i))
                        {
                          localObject1 = localParameters.getSupportedFlashModes();
                          if ((localObject1 != null) && (((List)localObject1).contains("torch"))) {
                            localParameters.setFlashMode("torch");
                          }
                        }
                        this.b.setParameters(localParameters);
                        if (i1 != 0) {
                          Log.i("cameraview/prepare-video restart preview");
                        }
                      }
                      try
                      {
                        this.b.setPreviewDisplay(this.a);
                        this.b.startPreview();
                        this.e = true;
                        requestLayout();
                        this.b.unlock();
                        this.j.setCamera(this.b);
                        if (this.x.a("android.permission.RECORD_AUDIO") == 0)
                        {
                          this.j.setAudioSource(5);
                          this.j.setVideoSource(1);
                          if (this.x.a("android.permission.RECORD_AUDIO") != 0) {
                            break label1776;
                          }
                          this.j.setProfile(localCamcorderProfile);
                          this.j.setOutputFile(paramFile.getAbsolutePath());
                          this.j.setPreviewDisplay(getHolder().getSurface());
                          int i2 = getRequiredCameraRotation();
                          i1 = i2;
                          if (this.g) {
                            if (Build.VERSION.SDK_INT != 14)
                            {
                              i1 = i2;
                              if (Build.VERSION.SDK_INT != 15) {}
                            }
                            else
                            {
                              i1 = i2;
                              if (Build.MANUFACTURER.equals("HTC")) {
                                i1 = (360 - i2) % 360;
                              }
                            }
                          }
                          this.j.setOrientationHint((i1 + paramInt) % 360);
                        }
                        try
                        {
                          Log.d("cameraview/prepare-video prepare recorder");
                          this.j.prepare();
                          return true;
                        }
                        catch (IllegalStateException paramFile)
                        {
                          Log.d("cameraview/prepare-video IllegalStateException preparing MediaRecorder: " + paramFile.getMessage());
                          i();
                          b(1);
                          return false;
                        }
                        catch (IOException paramFile)
                        {
                          Log.d("cameraview/prepare-video IOException preparing MediaRecorder: " + paramFile.getMessage());
                          i();
                          b(1);
                          return false;
                        }
                        if (((List)localObject1).contains("infinity"))
                        {
                          localParameters.setFocusMode("infinity");
                          continue;
                          Log.i("cameraview/prepare-video supported focus: null");
                          continue;
                          i1 = 0;
                        }
                      }
                      catch (IOException localIOException)
                      {
                        for (;;)
                        {
                          Log.d("cameraview/prepare-video  error setting preview display", localIOException);
                          continue;
                          Log.w("camerview/prepare-video record audio denied, will record without sound");
                          continue;
                          this.j.setOutputFormat(localCamcorderProfile.fileFormat);
                          this.j.setVideoFrameRate(localCamcorderProfile.videoFrameRate);
                          this.j.setVideoSize(localCamcorderProfile.videoFrameWidth, localCamcorderProfile.videoFrameHeight);
                          this.j.setVideoEncodingBitRate(localCamcorderProfile.videoBitRate);
                          this.j.setVideoEncoder(localCamcorderProfile.videoCodec);
                        }
                      }
                    }
                    localObject3 = localObject5;
                  }
                }
                localObject6 = localIOException;
                Object localObject2 = localObject5;
              }
              localObject5 = null;
            }
          }
          i1 = Integer.MAX_VALUE;
          localObject3 = null;
        }
      }
    }
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +209 -> 217
    //   11: aload_0
    //   12: getfield 148	com/whatsapp/camera/CameraView:h	I
    //   15: invokestatic 637	android/hardware/Camera:getNumberOfCameras	()I
    //   18: if_icmplt +12 -> 30
    //   21: aload_0
    //   22: invokestatic 637	android/hardware/Camera:getNumberOfCameras	()I
    //   25: iconst_1
    //   26: isub
    //   27: putfield 148	com/whatsapp/camera/CameraView:h	I
    //   30: aload_0
    //   31: aload_0
    //   32: getfield 148	com/whatsapp/camera/CameraView:h	I
    //   35: invokestatic 641	android/hardware/Camera:open	(I)Landroid/hardware/Camera;
    //   38: putfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   41: aload_0
    //   42: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   45: aload_0
    //   46: invokestatic 646	com/whatsapp/camera/ac:a	(Lcom/whatsapp/camera/CameraView;)Landroid/hardware/Camera$ErrorCallback;
    //   49: invokevirtual 650	android/hardware/Camera:setErrorCallback	(Landroid/hardware/Camera$ErrorCallback;)V
    //   52: aload_0
    //   53: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   56: astore_1
    //   57: aload_1
    //   58: ifnull +18 -> 76
    //   61: aload_0
    //   62: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   65: aload_0
    //   66: getfield 162	com/whatsapp/camera/CameraView:a	Landroid/view/SurfaceHolder;
    //   69: invokevirtual 529	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   72: aload_0
    //   73: invokespecial 652	com/whatsapp/camera/CameraView:h	()V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   84: ifnull +10 -> 94
    //   87: aload_0
    //   88: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   91: invokevirtual 655	android/hardware/Camera:release	()V
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   99: ldc_w 657
    //   102: aload_1
    //   103: invokestatic 596	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload_0
    //   107: getfield 148	com/whatsapp/camera/CameraView:h	I
    //   110: ifeq +31 -> 141
    //   113: aload_0
    //   114: invokevirtual 661	com/whatsapp/camera/CameraView:getContext	()Landroid/content/Context;
    //   117: ldc -124
    //   119: iconst_0
    //   120: invokevirtual 138	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   123: invokeinterface 665 1 0
    //   128: ldc -116
    //   130: iconst_0
    //   131: invokeinterface 671 3 0
    //   136: invokeinterface 674 1 0
    //   141: aload_0
    //   142: iconst_1
    //   143: invokevirtual 622	com/whatsapp/camera/CameraView:b	(I)V
    //   146: goto -94 -> 52
    //   149: astore_1
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    //   154: astore_1
    //   155: aload_0
    //   156: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   159: invokevirtual 655	android/hardware/Camera:release	()V
    //   162: aload_0
    //   163: aconst_null
    //   164: putfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   167: ldc_w 676
    //   170: aload_1
    //   171: invokestatic 596	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   174: aload_0
    //   175: getfield 148	com/whatsapp/camera/CameraView:h	I
    //   178: ifeq +31 -> 209
    //   181: aload_0
    //   182: invokevirtual 661	com/whatsapp/camera/CameraView:getContext	()Landroid/content/Context;
    //   185: ldc -124
    //   187: iconst_0
    //   188: invokevirtual 138	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   191: invokeinterface 665 1 0
    //   196: ldc -116
    //   198: iconst_0
    //   199: invokeinterface 671 3 0
    //   204: invokeinterface 674 1 0
    //   209: aload_0
    //   210: iconst_1
    //   211: invokevirtual 622	com/whatsapp/camera/CameraView:b	(I)V
    //   214: goto -138 -> 76
    //   217: aload_0
    //   218: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   221: invokevirtual 679	android/hardware/Camera:reconnect	()V
    //   224: goto -148 -> 76
    //   227: astore_1
    //   228: aload_0
    //   229: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   232: invokevirtual 655	android/hardware/Camera:release	()V
    //   235: aload_0
    //   236: aconst_null
    //   237: putfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   240: ldc_w 681
    //   243: aload_1
    //   244: invokestatic 596	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   247: aload_0
    //   248: iconst_1
    //   249: invokevirtual 622	com/whatsapp/camera/CameraView:b	(I)V
    //   252: goto -176 -> 76
    //   255: astore_1
    //   256: goto -101 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	CameraView
    //   6	52	1	localCamera	Camera
    //   79	24	1	localException	Exception
    //   149	4	1	localObject	Object
    //   154	17	1	localRuntimeException	RuntimeException
    //   227	17	1	localIOException1	IOException
    //   255	1	1	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   11	30	79	java/lang/Exception
    //   30	52	79	java/lang/Exception
    //   2	7	149	finally
    //   11	30	149	finally
    //   30	52	149	finally
    //   52	57	149	finally
    //   61	76	149	finally
    //   80	94	149	finally
    //   94	141	149	finally
    //   141	146	149	finally
    //   155	209	149	finally
    //   209	214	149	finally
    //   217	224	149	finally
    //   228	252	149	finally
    //   61	76	154	java/lang/RuntimeException
    //   217	224	227	java/io/IOException
    //   61	76	255	java/io/IOException
  }
  
  private List<Camera.Size> getFallbackSupportedPreviewSizes()
  {
    Log.i("cameraview/fallback-supported-preview-sizes");
    ArrayList localArrayList = new ArrayList();
    Camera localCamera = this.b;
    localCamera.getClass();
    localArrayList.add(new Camera.Size(localCamera, 640, 480));
    return localArrayList;
  }
  
  private int getRequiredCameraRotation()
  {
    int i2 = 0;
    int i4 = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getOrientation();
    this.g = false;
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(this.h, localCameraInfo);
    boolean bool;
    int i3;
    int i1;
    if (localCameraInfo.facing == 1)
    {
      bool = true;
      this.g = bool;
      i3 = localCameraInfo.orientation;
      i1 = i2;
      switch (i4)
      {
      default: 
        i1 = i2;
      case 0: 
        label106:
        if (!this.g) {
          break;
        }
      }
    }
    for (i2 = (i3 + i1 + 360) % 360;; i2 = (i3 - i1 + 360) % 360)
    {
      Log.i("cameraview/orientation display:" + i1 + " camera:" + i3 + " rotate:" + i2);
      return i2;
      bool = false;
      break;
      i1 = 90;
      break label106;
      i1 = 180;
      break label106;
      i1 = 270;
      break label106;
    }
  }
  
  private void h()
  {
    int i1;
    int i2;
    int i5;
    boolean bool1;
    int i3;
    label166:
    int i4;
    label481:
    label494:
    label501:
    label507:
    label548:
    label574:
    label734:
    label926:
    Camera.Size localSize;
    for (;;)
    {
      Object localObject1;
      try
      {
        i1 = getWidth();
        i2 = getHeight();
        Log.i("cameraview/start-preview view:" + i1 + "x" + i2);
        if (this.b == null)
        {
          Log.e("cameraview/start-preview camera is null");
          b(1);
          return;
        }
        i5 = this.r.getOrientation();
        if (i5 == 0) {
          break label1564;
        }
        if (i5 != 2) {
          break label481;
        }
      }
      finally {}
      Camera.Parameters localParameters1 = this.b.getParameters();
      this.m = localParameters1.getSupportedPreviewSizes();
      if (this.m == null) {
        this.m = getFallbackSupportedPreviewSizes();
      }
      if ((i1 != this.s) || (i2 != this.t) || (this.k == null))
      {
        localObject1 = this.m;
        if (bool1)
        {
          i3 = i2;
          break label1570;
          this.k = a((List)localObject1, i3, i4);
        }
      }
      else
      {
        if (this.i == null) {
          this.i = localParameters1.getFlashMode();
        }
        Log.i("cameraview/start-preview preview sizes:" + a(this.m));
        Log.i("cameraview/start-preview optimal preview size:" + this.k.width + "x" + this.k.height);
        localObject1 = new Camera.CameraInfo();
        Camera.getCameraInfo(this.h, (Camera.CameraInfo)localObject1);
        if (((Camera.CameraInfo)localObject1).facing != 1) {
          break label501;
        }
        bool2 = true;
        this.g = bool2;
        double d1 = Math.min(Math.abs(i1 / i2 - this.k.width / this.k.height), Math.abs(i2 / i1 - this.k.width / this.k.height));
        if ((d1 <= 0.1D) || ((i1 == this.s) && (i2 == this.t))) {
          break label507;
        }
        Log.i("cameraview/start-preview request layout to match preview size:" + this.k.width + "x" + this.k.height + " (view is " + i1 + "x" + i2 + ") aspect diff is " + d1);
        this.w.post(ad.a(this));
        continue;
        bool1 = false;
        continue;
      }
      i3 = i1;
      break label1570;
      i4 = i2;
      continue;
      boolean bool2 = false;
      continue;
      i3 = ((Camera.CameraInfo)localObject1).orientation;
      switch (i5)
      {
      default: 
        if (!this.g) {
          break label1632;
        }
        i2 = (360 - (i3 + i1) % 360) % 360;
        Log.i("cameraview/start-preview display:" + i1 + " camera:" + i3 + " preview:" + i2 + " front:" + this.g + " portrait:" + bool1);
        for (;;)
        {
          try
          {
            this.b.setDisplayOrientation(i2);
            localParameters2.setPreviewSize(this.k.width, this.k.height);
            localObject1 = localParameters2.getSupportedFocusModes();
            if (localObject1 != null)
            {
              Log.i("cameraview/start-preview supported focus:" + Arrays.deepToString(((List)localObject1).toArray()));
              if (!((List)localObject1).contains("continuous-picture")) {
                break label1650;
              }
              localParameters2.setFocusMode("continuous-picture");
              i5 = 1;
              localObject1 = localParameters2.getSupportedFlashModes();
              if (localObject1 == null) {
                break label1142;
              }
              Log.i("cameraview/start-preview supported flash:" + Arrays.deepToString(((List)localObject1).toArray()));
              if (this.i != null)
              {
                if (!((List)localObject1).contains(this.i)) {
                  break label1114;
                }
                localParameters2.setFlashMode(this.i);
                Log.i("cameraview/start-preview set flash mode:" + this.i);
              }
              localObject1 = localParameters2.getSupportedPictureSizes();
              Collections.sort((List)localObject1, ae.a());
              Log.i("cameraview/start-preview picture sizes:" + a((List)localObject1));
              i1 = 640;
              i2 = 480;
              if (this.k == null) {
                break;
              }
              float f3 = this.k.height / this.k.width;
              localObject2 = ((List)localObject1).iterator();
              i2 = 480;
              i1 = 640;
              float f1 = Float.MAX_VALUE;
              i4 = i2;
              i3 = i1;
              if (!((Iterator)localObject2).hasNext()) {
                break label1664;
              }
              localSize = (Camera.Size)((Iterator)localObject2).next();
              if (localSize.width * localSize.height >= 12000000) {
                break label1549;
              }
              if (f1 != Float.MAX_VALUE)
              {
                i4 = i2;
                i3 = i1;
                if (localSize.width * localSize.height << 1 < i1 * i2) {
                  break label1664;
                }
              }
              float f2 = Math.abs(localSize.height / localSize.width - f3);
              if (f2 >= f1) {
                break label1549;
              }
              i2 = localSize.height;
              i1 = localSize.width;
              if (f2 < 0.05F) {
                break label1656;
              }
              i3 = i1;
              f1 = f2;
              i1 = i2;
              i2 = i3;
            }
          }
          catch (RuntimeException localRuntimeException)
          {
            Log.e("cameraview/start-preview/setdisplayorientation " + localRuntimeException);
            continue;
            Log.i("cameraview/start-preview supported focus:null");
            break label1650;
          }
          label1114:
          if (!getFlashModes().contains(this.i))
          {
            this.i = localParameters2.getFlashMode();
            continue;
            label1142:
            Log.i("cameraview/start-preview supported flash:null");
            if (!getFlashModes().contains(this.i)) {
              this.i = "off";
            }
          }
        }
        label1174:
        i4 = i1;
        i3 = i2;
        if (this.g)
        {
          i4 = i1;
          i3 = i2;
          if ("samsung".equals(Build.MANUFACTURER))
          {
            i4 = i1;
            i3 = i2;
            if (d.a(z, Build.MODEL))
            {
              localObject2 = this.b;
              localObject2.getClass();
              localObject2 = new Camera.Size((Camera)localObject2, 1280, 720);
              if (!localRuntimeException.contains(localObject2)) {
                break label1470;
              }
              i3 = ((Camera.Size)localObject2).width;
              i4 = ((Camera.Size)localObject2).height;
              Log.i("cameraview/start-preview workaround s4 mini preview size");
            }
          }
        }
        label1290:
        Log.i("cameraview/start-preview picture size " + i3 + "x" + i4);
        localParameters2.setPictureSize(i3, i4);
        this.b.setParameters(localParameters2);
        this.b.startPreview();
        if (i5 == 0) {
          this.b.autoFocus(af.a());
        }
        this.e = true;
        if (this.f != null) {
          this.f.a();
        }
        break;
      }
    }
    Object localObject2 = localRuntimeException.iterator();
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localSize = (Camera.Size)((Iterator)localObject2).next();
        if ((localSize.width * localSize.height <= i1 * i2) || (localSize.width * localSize.height >= 12000000)) {
          break label1534;
        }
        i1 = localSize.height;
        i2 = localSize.width;
        break label1675;
        label1470:
        Log.i("cameraview/start-preview could not workaround s4 mini preview size " + ((Camera.Size)localObject2).width + "x" + ((Camera.Size)localObject2).height);
        i4 = i1;
        i3 = i2;
        break label1290;
      }
      i3 = i1;
      i1 = i2;
      i2 = i3;
      break label1174;
      label1534:
      i3 = i1;
      i1 = i2;
      i2 = i3;
      break label1675;
      label1549:
      i3 = i1;
      i1 = i2;
      i2 = i3;
      break label1588;
      label1564:
      bool1 = true;
      break;
      label1570:
      if (!bool1) {
        break label494;
      }
      i4 = i1;
      break label166;
      i1 = 0;
      break label548;
      label1588:
      i3 = i2;
      i2 = i1;
      i1 = i3;
      break label926;
      i1 = 0;
      break label548;
      i1 = 90;
      break label548;
      i1 = 180;
      break label548;
      i1 = 270;
      break label548;
      label1632:
      i2 = (i3 - i1 + 360) % 360;
      break label574;
      label1650:
      i5 = 0;
      break label734;
      label1656:
      i4 = i2;
      i3 = i1;
      label1664:
      i1 = i4;
      i2 = i3;
      break label1174;
      label1675:
      i3 = i2;
      i2 = i1;
      i1 = i3;
    }
  }
  
  private void i()
  {
    if (this.j != null)
    {
      this.j.reset();
      this.j.release();
      this.j = null;
      if (this.b == null) {}
    }
    try
    {
      this.b.lock();
      Camera.Parameters localParameters = this.b.getParameters();
      Log.d("cameraview/release-media-recorder/flash " + localParameters.getFlashMode());
      if ("torch".equals(localParameters.getFlashMode()))
      {
        localParameters.setFlashMode("off");
        this.b.setParameters(localParameters);
        this.b.stopPreview();
        this.e = false;
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.d("failed to lock the camera, it's in use by another process or WhatsApp video call.", localRuntimeException);
    }
  }
  
  /* Error */
  public final int a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   8: astore 4
    //   10: aload 4
    //   12: ifnonnull +9 -> 21
    //   15: iload_3
    //   16: istore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_2
    //   20: ireturn
    //   21: aload_0
    //   22: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   25: invokevirtual 373	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   28: astore 4
    //   30: iload_3
    //   31: istore_2
    //   32: aload 4
    //   34: invokevirtual 838	android/hardware/Camera$Parameters:isZoomSupported	()Z
    //   37: ifeq -20 -> 17
    //   40: iload_3
    //   41: istore_2
    //   42: iload_1
    //   43: aload 4
    //   45: invokevirtual 841	android/hardware/Camera$Parameters:getMaxZoom	()I
    //   48: if_icmpgt -31 -> 17
    //   51: aload 4
    //   53: invokevirtual 844	android/hardware/Camera$Parameters:getZoom	()I
    //   56: iload_1
    //   57: if_icmpeq +18 -> 75
    //   60: aload 4
    //   62: iload_1
    //   63: invokevirtual 847	android/hardware/Camera$Parameters:setZoom	(I)V
    //   66: aload_0
    //   67: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   70: aload 4
    //   72: invokevirtual 523	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   75: aload 4
    //   77: invokevirtual 850	android/hardware/Camera$Parameters:getZoomRatios	()Ljava/util/List;
    //   80: astore 4
    //   82: iload_3
    //   83: istore_2
    //   84: aload 4
    //   86: ifnull -69 -> 17
    //   89: iload_3
    //   90: istore_2
    //   91: aload 4
    //   93: invokeinterface 853 1 0
    //   98: iload_1
    //   99: if_icmplt -82 -> 17
    //   102: aload 4
    //   104: iload_1
    //   105: invokeinterface 856 2 0
    //   110: checkcast 858	java/lang/Integer
    //   113: invokevirtual 861	java/lang/Integer:intValue	()I
    //   116: istore_2
    //   117: goto -100 -> 17
    //   120: astore 4
    //   122: aload_0
    //   123: monitorexit
    //   124: aload 4
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	CameraView
    //   0	127	1	paramInt	int
    //   16	101	2	i1	int
    //   1	89	3	i2	int
    //   8	95	4	localObject1	Object
    //   120	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	10	120	finally
    //   21	30	120	finally
    //   32	40	120	finally
    //   42	75	120	finally
    //   75	82	120	finally
    //   91	117	120	finally
  }
  
  final void a()
  {
    this.p = 1.0F;
    this.v.post(ab.a(this));
  }
  
  /* Error */
  final void a(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   20: invokevirtual 870	android/hardware/Camera:cancelAutoFocus	()V
    //   23: iconst_0
    //   24: istore 4
    //   26: iload 4
    //   28: istore_3
    //   29: getstatic 317	android/os/Build$VERSION:SDK_INT	I
    //   32: bipush 14
    //   34: if_icmplt +524 -> 558
    //   37: new 872	android/graphics/Rect
    //   40: dup
    //   41: fload_1
    //   42: ldc_w 873
    //   45: fsub
    //   46: f2i
    //   47: fload_2
    //   48: ldc_w 873
    //   51: fsub
    //   52: f2i
    //   53: fload_1
    //   54: ldc_w 873
    //   57: fadd
    //   58: f2i
    //   59: ldc_w 873
    //   62: fload_2
    //   63: fadd
    //   64: f2i
    //   65: invokespecial 876	android/graphics/Rect:<init>	(IIII)V
    //   68: astore 6
    //   70: new 872	android/graphics/Rect
    //   73: dup
    //   74: invokespecial 877	android/graphics/Rect:<init>	()V
    //   77: astore 5
    //   79: aload 5
    //   81: aload 6
    //   83: getfield 880	android/graphics/Rect:left	I
    //   86: sipush 2000
    //   89: imul
    //   90: aload_0
    //   91: invokevirtual 717	com/whatsapp/camera/CameraView:getWidth	()I
    //   94: idiv
    //   95: sipush 1000
    //   98: isub
    //   99: aload 6
    //   101: getfield 883	android/graphics/Rect:top	I
    //   104: sipush 2000
    //   107: imul
    //   108: aload_0
    //   109: invokevirtual 720	com/whatsapp/camera/CameraView:getHeight	()I
    //   112: idiv
    //   113: sipush 1000
    //   116: isub
    //   117: aload 6
    //   119: getfield 886	android/graphics/Rect:right	I
    //   122: sipush 2000
    //   125: imul
    //   126: aload_0
    //   127: invokevirtual 717	com/whatsapp/camera/CameraView:getWidth	()I
    //   130: idiv
    //   131: sipush 1000
    //   134: isub
    //   135: aload 6
    //   137: getfield 889	android/graphics/Rect:bottom	I
    //   140: sipush 2000
    //   143: imul
    //   144: aload_0
    //   145: invokevirtual 720	com/whatsapp/camera/CameraView:getHeight	()I
    //   148: idiv
    //   149: sipush 1000
    //   152: isub
    //   153: invokevirtual 891	android/graphics/Rect:set	(IIII)V
    //   156: aload 5
    //   158: getfield 880	android/graphics/Rect:left	I
    //   161: sipush 64536
    //   164: if_icmpge +11 -> 175
    //   167: aload 5
    //   169: sipush 64536
    //   172: putfield 880	android/graphics/Rect:left	I
    //   175: aload 5
    //   177: getfield 883	android/graphics/Rect:top	I
    //   180: sipush 64536
    //   183: if_icmpge +11 -> 194
    //   186: aload 5
    //   188: sipush 64536
    //   191: putfield 883	android/graphics/Rect:top	I
    //   194: aload 5
    //   196: getfield 886	android/graphics/Rect:right	I
    //   199: sipush 1000
    //   202: if_icmple +11 -> 213
    //   205: aload 5
    //   207: sipush 1000
    //   210: putfield 886	android/graphics/Rect:right	I
    //   213: aload 5
    //   215: getfield 889	android/graphics/Rect:bottom	I
    //   218: sipush 1000
    //   221: if_icmple +11 -> 232
    //   224: aload 5
    //   226: sipush 1000
    //   229: putfield 889	android/graphics/Rect:bottom	I
    //   232: aload 5
    //   234: getfield 883	android/graphics/Rect:top	I
    //   237: aload 5
    //   239: getfield 889	android/graphics/Rect:bottom	I
    //   242: isub
    //   243: invokestatic 297	java/lang/Math:abs	(I)I
    //   246: bipush 10
    //   248: if_icmpge +65 -> 313
    //   251: aload 5
    //   253: aload 5
    //   255: getfield 883	android/graphics/Rect:top	I
    //   258: iconst_5
    //   259: isub
    //   260: putfield 883	android/graphics/Rect:top	I
    //   263: aload 5
    //   265: aload 5
    //   267: getfield 889	android/graphics/Rect:bottom	I
    //   270: iconst_5
    //   271: iadd
    //   272: putfield 889	android/graphics/Rect:bottom	I
    //   275: aload 5
    //   277: getfield 883	android/graphics/Rect:top	I
    //   280: sipush 64536
    //   283: if_icmpge +11 -> 294
    //   286: aload 5
    //   288: sipush 64536
    //   291: putfield 883	android/graphics/Rect:top	I
    //   294: aload 5
    //   296: getfield 883	android/graphics/Rect:top	I
    //   299: sipush 1000
    //   302: if_icmple +11 -> 313
    //   305: aload 5
    //   307: sipush 1000
    //   310: putfield 883	android/graphics/Rect:top	I
    //   313: aload 5
    //   315: getfield 880	android/graphics/Rect:left	I
    //   318: aload 5
    //   320: getfield 886	android/graphics/Rect:right	I
    //   323: isub
    //   324: invokestatic 297	java/lang/Math:abs	(I)I
    //   327: bipush 10
    //   329: if_icmpge +65 -> 394
    //   332: aload 5
    //   334: aload 5
    //   336: getfield 880	android/graphics/Rect:left	I
    //   339: iconst_5
    //   340: isub
    //   341: putfield 880	android/graphics/Rect:left	I
    //   344: aload 5
    //   346: aload 5
    //   348: getfield 886	android/graphics/Rect:right	I
    //   351: iconst_5
    //   352: iadd
    //   353: putfield 886	android/graphics/Rect:right	I
    //   356: aload 5
    //   358: getfield 880	android/graphics/Rect:left	I
    //   361: sipush 64536
    //   364: if_icmpge +11 -> 375
    //   367: aload 5
    //   369: sipush 64536
    //   372: putfield 880	android/graphics/Rect:left	I
    //   375: aload 5
    //   377: getfield 886	android/graphics/Rect:right	I
    //   380: sipush 1000
    //   383: if_icmpge +11 -> 394
    //   386: aload 5
    //   388: sipush 1000
    //   391: putfield 886	android/graphics/Rect:right	I
    //   394: new 255	java/lang/StringBuilder
    //   397: dup
    //   398: ldc_w 893
    //   401: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   404: aload 5
    //   406: getfield 880	android/graphics/Rect:left	I
    //   409: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   412: ldc_w 895
    //   415: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload 5
    //   420: getfield 883	android/graphics/Rect:top	I
    //   423: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   426: ldc_w 895
    //   429: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload 5
    //   434: getfield 886	android/graphics/Rect:right	I
    //   437: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   440: ldc_w 895
    //   443: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload 5
    //   448: getfield 889	android/graphics/Rect:bottom	I
    //   451: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   454: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 584	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   460: aload_0
    //   461: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   464: invokevirtual 373	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   467: astore 6
    //   469: iload 4
    //   471: istore_3
    //   472: aload 6
    //   474: invokevirtual 898	android/hardware/Camera$Parameters:getMaxNumFocusAreas	()I
    //   477: ifle +81 -> 558
    //   480: iconst_1
    //   481: istore_3
    //   482: new 685	java/util/ArrayList
    //   485: dup
    //   486: invokespecial 686	java/util/ArrayList:<init>	()V
    //   489: astore 7
    //   491: aload 7
    //   493: new 900	android/hardware/Camera$Area
    //   496: dup
    //   497: aload 5
    //   499: sipush 1000
    //   502: invokespecial 903	android/hardware/Camera$Area:<init>	(Landroid/graphics/Rect;I)V
    //   505: invokevirtual 689	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   508: pop
    //   509: aload 6
    //   511: aload 7
    //   513: invokevirtual 907	android/hardware/Camera$Parameters:setFocusAreas	(Ljava/util/List;)V
    //   516: aload 6
    //   518: invokevirtual 472	android/hardware/Camera$Parameters:getSupportedFocusModes	()Ljava/util/List;
    //   521: astore 5
    //   523: aload 5
    //   525: ifnull +24 -> 549
    //   528: aload 5
    //   530: ldc_w 909
    //   533: invokeinterface 489 2 0
    //   538: ifeq +11 -> 549
    //   541: aload 6
    //   543: ldc_w 909
    //   546: invokevirtual 492	android/hardware/Camera$Parameters:setFocusMode	(Ljava/lang/String;)V
    //   549: aload_0
    //   550: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   553: aload 6
    //   555: invokevirtual 523	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   558: iload_3
    //   559: ifeq +14 -> 573
    //   562: aload_0
    //   563: getfield 820	com/whatsapp/camera/CameraView:f	Lcom/whatsapp/camera/CameraView$a;
    //   566: fload_1
    //   567: fload_2
    //   568: invokeinterface 911 3 0
    //   573: aload_0
    //   574: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   577: aload_0
    //   578: invokestatic 916	com/whatsapp/camera/z:a	(Lcom/whatsapp/camera/CameraView;)Landroid/hardware/Camera$AutoFocusCallback;
    //   581: invokevirtual 818	android/hardware/Camera:autoFocus	(Landroid/hardware/Camera$AutoFocusCallback;)V
    //   584: goto -571 -> 13
    //   587: astore 5
    //   589: aload_0
    //   590: monitorexit
    //   591: aload 5
    //   593: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	this	CameraView
    //   0	594	1	paramFloat1	float
    //   0	594	2	paramFloat2	float
    //   28	531	3	i1	int
    //   24	446	4	i2	int
    //   6	523	5	localObject1	Object
    //   587	5	5	localObject2	Object
    //   68	486	6	localObject3	Object
    //   489	23	7	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	8	587	finally
    //   16	23	587	finally
    //   29	175	587	finally
    //   175	194	587	finally
    //   194	213	587	finally
    //   213	232	587	finally
    //   232	294	587	finally
    //   294	313	587	finally
    //   313	375	587	finally
    //   375	394	587	finally
    //   394	469	587	finally
    //   472	480	587	finally
    //   482	523	587	finally
    //   528	549	587	finally
    //   549	558	587	finally
    //   562	573	587	finally
    //   573	584	587	finally
  }
  
  final void a(SurfaceHolder paramSurfaceHolder)
  {
    this.v.post(aa.a(this, paramSurfaceHolder));
  }
  
  public final void a(c paramc)
  {
    for (;;)
    {
      try
      {
        if (this.b == null)
        {
          Log.e("cameraview/take-picture camera is null");
          b(1);
          return;
        }
        if (this.d)
        {
          Log.e("cameraview/take-picture already taking a picture");
          continue;
        }
        this.e = false;
      }
      finally {}
      this.d = true;
      Log.i("cameraview/take-picture/start");
      Object localObject = this.b.getParameters();
      ((Camera.Parameters)localObject).setRotation(getRequiredCameraRotation());
      ((Camera.Parameters)localObject).setJpegQuality(80);
      this.b.setParameters((Camera.Parameters)localObject);
      try
      {
        localObject = ag.a(this, paramc);
        paramc.getClass();
        paramc = ah.a(paramc);
        this.b.takePicture(paramc, null, (Camera.PictureCallback)localObject);
      }
      catch (Exception paramc)
      {
        this.d = false;
        Log.d("cameraview/take-picture failed", paramc);
        b(1);
      }
    }
  }
  
  public final void a(File paramFile, int paramInt)
  {
    for (;;)
    {
      try
      {
        boolean bool = b(paramFile, paramInt);
        if (bool) {
          try
          {
            Log.i("cameraview/start-video-capture");
            this.j.start();
            this.c = true;
            return;
          }
          catch (RuntimeException paramFile)
          {
            Log.d("cameraview/start-video-capture failed", paramFile);
            i();
            b(1);
            continue;
          }
        }
        Log.e("cameraview/start-video-capture failed");
      }
      finally {}
      i();
      b(1);
    }
  }
  
  /* Error */
  final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 966
    //   5: invokestatic 294	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +27 -> 41
    //   17: aload_0
    //   18: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   21: invokevirtual 507	android/hardware/Camera:stopPreview	()V
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 509	com/whatsapp/camera/CameraView:e	Z
    //   29: aload_0
    //   30: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   33: invokevirtual 655	android/hardware/Camera:release	()V
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   41: ldc_w 968
    //   44: invokestatic 294	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: astore_1
    //   51: ldc_w 970
    //   54: aload_1
    //   55: invokestatic 972	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   58: goto -29 -> 29
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    //   66: astore_1
    //   67: ldc_w 974
    //   70: aload_1
    //   71: invokestatic 972	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   74: goto -38 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	CameraView
    //   12	2	1	localCamera	Camera
    //   50	5	1	localException1	Exception
    //   61	4	1	localObject	Object
    //   66	5	1	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   17	29	50	java/lang/Exception
    //   2	13	61	finally
    //   17	29	61	finally
    //   29	36	61	finally
    //   36	41	61	finally
    //   41	47	61	finally
    //   51	58	61	finally
    //   67	74	61	finally
    //   29	36	66	java/lang/Exception
  }
  
  final void b(int paramInt)
  {
    if (this.f != null) {
      this.f.a(paramInt);
    }
  }
  
  /* Error */
  final void b(SurfaceHolder paramSurfaceHolder)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_1
    //   15: invokeinterface 979 1 0
    //   20: ifne +21 -> 41
    //   23: ldc_w 981
    //   26: invokestatic 584	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   33: invokevirtual 507	android/hardware/Camera:stopPreview	()V
    //   36: aload_0
    //   37: iconst_0
    //   38: putfield 509	com/whatsapp/camera/CameraView:e	Z
    //   41: aload_0
    //   42: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   45: aload_1
    //   46: invokevirtual 529	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   49: aload_0
    //   50: invokespecial 652	com/whatsapp/camera/CameraView:h	()V
    //   53: goto -42 -> 11
    //   56: astore_1
    //   57: aload_0
    //   58: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   61: invokevirtual 655	android/hardware/Camera:release	()V
    //   64: aload_0
    //   65: aconst_null
    //   66: putfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   69: ldc_w 983
    //   72: aload_1
    //   73: invokestatic 596	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: aload_0
    //   77: iconst_1
    //   78: invokevirtual 622	com/whatsapp/camera/CameraView:b	(I)V
    //   81: goto -70 -> 11
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    //   89: astore_1
    //   90: aload_0
    //   91: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   94: invokevirtual 655	android/hardware/Camera:release	()V
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   102: ldc_w 985
    //   105: aload_1
    //   106: invokestatic 596	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   109: aload_0
    //   110: iconst_1
    //   111: invokevirtual 622	com/whatsapp/camera/CameraView:b	(I)V
    //   114: goto -103 -> 11
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	CameraView
    //   0	117	1	paramSurfaceHolder	SurfaceHolder
    //   6	2	2	localCamera	Camera
    // Exception table:
    //   from	to	target	type
    //   14	41	56	java/lang/RuntimeException
    //   41	53	56	java/lang/RuntimeException
    //   2	7	84	finally
    //   14	41	84	finally
    //   41	53	84	finally
    //   57	81	84	finally
    //   90	114	84	finally
    //   14	41	89	java/io/IOException
    //   41	53	89	java/io/IOException
  }
  
  public final void c()
  {
    try
    {
      Log.i("cameraview/next-camera");
      if ((this.b != null) && (Camera.getNumberOfCameras() > 1))
      {
        this.h = ((this.h + 1) % Camera.getNumberOfCameras());
        b();
        a();
        getContext().getSharedPreferences("com.whatsapp_preferences", 0).edit().putInt("camera_index", this.h).apply();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean d()
  {
    if ((!this.g) || (!"on".equals(this.i))) {}
    List localList;
    do
    {
      return false;
      localList = this.b.getParameters().getSupportedFlashModes();
    } while ((localList != null) && (localList.contains(this.i)));
    return true;
  }
  
  /* Error */
  public final String e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnonnull +10 -> 21
    //   14: aload 4
    //   16: astore_3
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_3
    //   20: areturn
    //   21: aload_0
    //   22: invokevirtual 798	com/whatsapp/camera/CameraView:getFlashModes	()Ljava/util/List;
    //   25: astore 6
    //   27: aload 4
    //   29: astore_3
    //   30: aload 6
    //   32: invokeinterface 388 1 0
    //   37: ifne -20 -> 17
    //   40: aload_0
    //   41: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   44: invokevirtual 373	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   47: astore 5
    //   49: aload_0
    //   50: getfield 156	com/whatsapp/camera/CameraView:i	Ljava/lang/String;
    //   53: ifnonnull +12 -> 65
    //   56: aload_0
    //   57: aload 5
    //   59: invokevirtual 735	android/hardware/Camera$Parameters:getFlashMode	()Ljava/lang/String;
    //   62: putfield 156	com/whatsapp/camera/CameraView:i	Ljava/lang/String;
    //   65: aload 6
    //   67: aload_0
    //   68: getfield 156	com/whatsapp/camera/CameraView:i	Ljava/lang/String;
    //   71: invokeinterface 992 2 0
    //   76: istore_2
    //   77: iload_2
    //   78: istore_1
    //   79: iload_2
    //   80: ifge +21 -> 101
    //   83: aload 6
    //   85: ldc_w 802
    //   88: invokeinterface 992 2 0
    //   93: istore_1
    //   94: aload 4
    //   96: astore_3
    //   97: iload_1
    //   98: iflt -81 -> 17
    //   101: aload_0
    //   102: aload 6
    //   104: iload_1
    //   105: iconst_1
    //   106: iadd
    //   107: aload 6
    //   109: invokeinterface 853 1 0
    //   114: irem
    //   115: invokeinterface 856 2 0
    //   120: checkcast 67	java/lang/String
    //   123: putfield 156	com/whatsapp/camera/CameraView:i	Ljava/lang/String;
    //   126: new 255	java/lang/StringBuilder
    //   129: dup
    //   130: ldc_w 994
    //   133: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   136: aload_0
    //   137: getfield 156	com/whatsapp/camera/CameraView:i	Ljava/lang/String;
    //   140: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 294	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   149: aload 5
    //   151: invokevirtual 514	android/hardware/Camera$Parameters:getSupportedFlashModes	()Ljava/util/List;
    //   154: astore_3
    //   155: aload_3
    //   156: ifnull +34 -> 190
    //   159: aload_3
    //   160: aload_0
    //   161: getfield 156	com/whatsapp/camera/CameraView:i	Ljava/lang/String;
    //   164: invokeinterface 489 2 0
    //   169: ifeq +21 -> 190
    //   172: aload 5
    //   174: aload_0
    //   175: getfield 156	com/whatsapp/camera/CameraView:i	Ljava/lang/String;
    //   178: invokevirtual 519	android/hardware/Camera$Parameters:setFlashMode	(Ljava/lang/String;)V
    //   181: aload_0
    //   182: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   185: aload 5
    //   187: invokevirtual 523	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   190: aload_0
    //   191: invokevirtual 661	com/whatsapp/camera/CameraView:getContext	()Landroid/content/Context;
    //   194: ldc -124
    //   196: iconst_0
    //   197: invokevirtual 138	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   200: invokeinterface 665 1 0
    //   205: ldc -106
    //   207: aload_0
    //   208: getfield 156	com/whatsapp/camera/CameraView:i	Ljava/lang/String;
    //   211: invokeinterface 998 3 0
    //   216: invokeinterface 674 1 0
    //   221: aload_0
    //   222: getfield 156	com/whatsapp/camera/CameraView:i	Ljava/lang/String;
    //   225: astore_3
    //   226: goto -209 -> 17
    //   229: astore_3
    //   230: aload_0
    //   231: monitorexit
    //   232: aload_3
    //   233: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	CameraView
    //   78	29	1	i1	int
    //   76	4	2	i2	int
    //   9	217	3	localObject1	Object
    //   229	4	3	localObject2	Object
    //   1	94	4	localObject3	Object
    //   47	139	5	localParameters	Camera.Parameters
    //   25	83	6	localList	List
    // Exception table:
    //   from	to	target	type
    //   5	10	229	finally
    //   21	27	229	finally
    //   30	65	229	finally
    //   65	77	229	finally
    //   83	94	229	finally
    //   101	155	229	finally
    //   159	190	229	finally
    //   190	226	229	finally
  }
  
  public final void f()
  {
    try
    {
      this.j.stop();
      i();
      if (this.b != null) {
        this.b.lock();
      }
      this.c = false;
      this.l = null;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        Log.w("cameraview/stop-video-capture " + localRuntimeException);
      }
    }
    finally {}
  }
  
  public int getCameraIndex()
  {
    return this.h;
  }
  
  public String getFlashMode()
  {
    return this.i;
  }
  
  /* Error */
  public List<String> getFlashModes()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 685	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 686	java/util/ArrayList:<init>	()V
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnonnull +7 -> 23
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: areturn
    //   23: aload_0
    //   24: getfield 367	com/whatsapp/camera/CameraView:b	Landroid/hardware/Camera;
    //   27: invokevirtual 373	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   30: invokevirtual 514	android/hardware/Camera$Parameters:getSupportedFlashModes	()Ljava/util/List;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +69 -> 104
    //   38: aload_2
    //   39: ldc_w 802
    //   42: invokeinterface 489 2 0
    //   47: ifeq +13 -> 60
    //   50: aload_1
    //   51: ldc_w 802
    //   54: invokeinterface 1005 2 0
    //   59: pop
    //   60: aload_2
    //   61: ldc_w 511
    //   64: invokeinterface 489 2 0
    //   69: ifeq +13 -> 82
    //   72: aload_1
    //   73: ldc_w 511
    //   76: invokeinterface 1005 2 0
    //   81: pop
    //   82: aload_2
    //   83: ldc_w 909
    //   86: invokeinterface 489 2 0
    //   91: ifeq +13 -> 104
    //   94: aload_1
    //   95: ldc_w 909
    //   98: invokeinterface 1005 2 0
    //   103: pop
    //   104: aload_0
    //   105: getfield 307	com/whatsapp/camera/CameraView:g	Z
    //   108: ifeq +47 -> 155
    //   111: aload_1
    //   112: ldc_w 802
    //   115: invokeinterface 489 2 0
    //   120: ifne +13 -> 133
    //   123: aload_1
    //   124: ldc_w 802
    //   127: invokeinterface 1005 2 0
    //   132: pop
    //   133: aload_1
    //   134: ldc_w 511
    //   137: invokeinterface 489 2 0
    //   142: ifne +13 -> 155
    //   145: aload_1
    //   146: ldc_w 511
    //   149: invokeinterface 1005 2 0
    //   154: pop
    //   155: aload_0
    //   156: invokevirtual 1008	com/whatsapp/camera/CameraView:getStoredFlashModeCount	()I
    //   159: aload_1
    //   160: invokeinterface 853 1 0
    //   165: if_icmpeq -146 -> 19
    //   168: aload_0
    //   169: invokevirtual 661	com/whatsapp/camera/CameraView:getContext	()Landroid/content/Context;
    //   172: ldc -124
    //   174: iconst_0
    //   175: invokevirtual 138	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   178: invokeinterface 665 1 0
    //   183: new 255	java/lang/StringBuilder
    //   186: dup
    //   187: ldc_w 1010
    //   190: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   193: aload_0
    //   194: getfield 148	com/whatsapp/camera/CameraView:h	I
    //   197: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: aload_1
    //   204: invokeinterface 853 1 0
    //   209: invokeinterface 671 3 0
    //   214: invokeinterface 674 1 0
    //   219: goto -200 -> 19
    //   222: astore_1
    //   223: aload_0
    //   224: monitorexit
    //   225: aload_1
    //   226: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	CameraView
    //   9	195	1	localArrayList	ArrayList
    //   222	4	1	localObject1	Object
    //   14	69	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	222	finally
    //   23	34	222	finally
    //   38	60	222	finally
    //   60	82	222	finally
    //   82	104	222	finally
    //   104	133	222	finally
    //   133	155	222	finally
    //   155	219	222	finally
  }
  
  public int getMaxZoom()
  {
    int i2 = 0;
    int i1 = i2;
    try
    {
      if (this.b != null)
      {
        Camera.Parameters localParameters = this.b.getParameters();
        i1 = i2;
        if (localParameters.isZoomSupported()) {
          i1 = localParameters.getMaxZoom();
        }
      }
      return i1;
    }
    finally {}
  }
  
  public int getStoredFlashModeCount()
  {
    return getContext().getSharedPreferences("com.whatsapp_preferences", 0).getInt("flash_mode_count" + this.h, 0);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.q.enable();
    this.u = new HandlerThread("Camera");
    this.u.start();
    this.v = new Handler(this.u.getLooper());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.q.disable();
    this.u.quit();
    this.u = null;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    c();
    return true;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.s = 0;
    this.t = 0;
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (this.b == null)
    {
      Log.d("cameraview/measure/no camera " + paramInt1 + "x" + paramInt2);
      return;
    }
    Object localObject;
    if (this.l != null) {
      localObject = this.l;
    }
    for (;;)
    {
      int i1;
      int i2;
      if (localObject == null)
      {
        Log.d("cameraview/measure/no preview");
        return;
        if (this.m != null)
        {
          i1 = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getOrientation();
          if ((i1 == 0) || (i1 == 2))
          {
            i2 = 1;
            label132:
            localObject = this.m;
            if (i2 == 0) {
              break label174;
            }
            i1 = paramInt2;
            label146:
            if (i2 == 0) {
              break label180;
            }
          }
          label174:
          label180:
          for (i2 = paramInt1;; i2 = paramInt2)
          {
            localObject = a((List)localObject, i1, i2);
            break;
            i2 = 0;
            break label132;
            i1 = paramInt1;
            break label146;
          }
        }
      }
      else
      {
        double d1 = Math.min(Math.abs(paramInt1 / paramInt2 - ((Camera.Size)localObject).width / ((Camera.Size)localObject).height), Math.abs(paramInt2 / paramInt1 - ((Camera.Size)localObject).width / ((Camera.Size)localObject).height));
        Log.i("cameraview/measure optimalpreviewsize:" + ((Camera.Size)localObject).width + "x" + ((Camera.Size)localObject).height + " measured:" + paramInt1 + "x" + paramInt2 + " aspect diff:" + d1);
        if (d1 <= 0.1D) {
          break;
        }
        label334:
        double d2;
        double d3;
        if (paramInt1 > paramInt2)
        {
          i1 = 1;
          if (((Camera.Size)localObject).width <= ((Camera.Size)localObject).height) {
            break label510;
          }
          i2 = 1;
          if (i1 != i2) {
            break label516;
          }
          d2 = Math.min(paramInt1 / ((Camera.Size)localObject).width, paramInt2 / ((Camera.Size)localObject).height);
          d3 = Math.max(paramInt1 / ((Camera.Size)localObject).width, paramInt2 / ((Camera.Size)localObject).height);
          Log.i("cameraview/measure optimalpreviewsize scaleMin:" + d2 + " scaleMax:" + d3);
          d1 = d3;
          if (d3 / d2 > 1.1D) {
            d1 = d2;
          }
          paramInt1 = (int)(((Camera.Size)localObject).width * d1);
        }
        for (paramInt2 = (int)(d1 * ((Camera.Size)localObject).height);; paramInt2 = (int)(d1 * ((Camera.Size)localObject).width))
        {
          Log.i("cameraview/measure result:" + paramInt1 + "x" + paramInt2);
          this.s = paramInt1;
          this.t = paramInt2;
          setMeasuredDimension(paramInt1, paramInt2);
          return;
          i1 = 0;
          break;
          label510:
          i2 = 0;
          break label334;
          label516:
          d2 = Math.min(paramInt1 / ((Camera.Size)localObject).height, paramInt2 / ((Camera.Size)localObject).width);
          d3 = Math.max(paramInt1 / ((Camera.Size)localObject).height, paramInt2 / ((Camera.Size)localObject).width);
          Log.i("cameraview/measure optimalpreviewsize scaleMin:" + d2 + " scaleMax:" + d3);
          d1 = d3;
          if (d3 / d2 > 1.1D) {
            d1 = d2;
          }
          paramInt1 = (int)(((Camera.Size)localObject).height * d1);
        }
      }
      localObject = null;
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((this.b == null) || (getMaxZoom() == 0)) {
      return true;
    }
    float f1 = paramScaleGestureDetector.getScaleFactor();
    this.p = (f1 * (this.p * f1));
    if (this.p < 1.0F) {
      this.p = 1.0F;
    }
    Log.d("cameraview/on-scale " + this.p);
    this.f.b(this.p);
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((this.b == null) || (getMaxZoom() == 0)) {
      return true;
    }
    Log.d("cameraview/on-scale-begin " + this.p);
    this.f.a(this.p);
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((this.b == null) || (getMaxZoom() == 0)) {
      return;
    }
    Log.d("cameraview/on-scale-end " + this.p);
    this.f.b();
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (!this.e) {
      return true;
    }
    this.f.c();
    Log.d("cameraview/focus  " + paramMotionEvent.getX() + " " + paramMotionEvent.getY());
    this.v.post(y.a(this, paramMotionEvent));
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.o.a(paramMotionEvent);
    if (this.n != null) {
      this.n.onTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public void setCameraCallback(a parama)
  {
    this.f = parama;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.b == null) {}
    do
    {
      return;
      if (this.a.getSurface() == null)
      {
        Log.e("cameraview/surface-changed: no surface");
        b(1);
        return;
      }
      Log.d("cameraview/surface-changed format:" + paramInt1 + " " + paramInt2 + "x" + paramInt3);
    } while (this.c);
    a(paramSurfaceHolder);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    Log.d("cameraview/surface-created");
    a();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    Log.d("cameraview/surface-destroyed");
    this.v.post(w.a(this));
    i();
  }
  
  static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(float paramFloat);
    
    public abstract void a(float paramFloat1, float paramFloat2);
    
    public abstract void a(int paramInt);
    
    public abstract void a(boolean paramBoolean);
    
    public abstract void b();
    
    public abstract void b(float paramFloat);
    
    public abstract void c();
  }
  
  final class b
    extends OrientationEventListener
  {
    private int b = -1;
    
    b(Context paramContext)
    {
      super();
    }
    
    public final void enable()
    {
      super.enable();
      this.b = CameraView.a(CameraView.this).getOrientation();
    }
    
    public final void onOrientationChanged(int paramInt)
    {
      paramInt = CameraView.a(CameraView.this).getOrientation();
      if ((paramInt != -1) && (paramInt != this.b) && (Math.abs(this.b - paramInt) % 2 == 0)) {
        CameraView.this.surfaceChanged(CameraView.b(CameraView.this), 0, 0, 0);
      }
      this.b = paramInt;
    }
  }
  
  static abstract interface c
  {
    public abstract void a();
    
    public abstract void a(byte[] paramArrayOfByte, boolean paramBoolean);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/camera/CameraView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */