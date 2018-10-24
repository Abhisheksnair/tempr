package com.whatsapp.util.undobar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

public class a
  extends LinearLayout
{
  public static final UndoBarStyle a;
  public static final UndoBarStyle b;
  public static final UndoBarStyle c;
  private static Animation f;
  private static Animation g;
  private UndoBarStyle e;
  private final TextView h;
  private final TextView i;
  private final Handler j;
  private final Runnable k;
  private c l;
  private Parcelable m;
  private CharSequence n;
  private int o;
  private boolean p;
  private String q;
  private boolean r;
  private float s;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      a = new UndoBarStyle(-1, 2131298059);
      b = new UndoBarStyle(2130840232, 2131297619, -1L);
      c = new UndoBarStyle(-1, -1, 5000L);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
      localTranslateAnimation.setDuration(500L);
      localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
      localTranslateAnimation.setAnimationListener(null);
      f = localTranslateAnimation;
      localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, 1.0F);
      localTranslateAnimation.setDuration(500L);
      localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
      localTranslateAnimation.setAnimationListener(null);
      g = localTranslateAnimation;
      return;
    }
  }
  
  /* Error */
  private a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: aload_1
    //   4: aconst_null
    //   5: invokespecial 111	android/widget/LinearLayout:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   8: aload_0
    //   9: getstatic 64	com/whatsapp/util/undobar/a:a	Lcom/whatsapp/util/undobar/UndoBarStyle;
    //   12: putfield 113	com/whatsapp/util/undobar/a:e	Lcom/whatsapp/util/undobar/UndoBarStyle;
    //   15: aload_0
    //   16: new 115	android/os/Handler
    //   19: dup
    //   20: invokestatic 121	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   23: invokespecial 124	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   26: putfield 126	com/whatsapp/util/undobar/a:j	Landroid/os/Handler;
    //   29: aload_0
    //   30: new 6	com/whatsapp/util/undobar/a$1
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 129	com/whatsapp/util/undobar/a$1:<init>	(Lcom/whatsapp/util/undobar/a;)V
    //   38: putfield 131	com/whatsapp/util/undobar/a:k	Ljava/lang/Runnable;
    //   41: aload_0
    //   42: iconst_m1
    //   43: putfield 133	com/whatsapp/util/undobar/a:o	I
    //   46: aload_1
    //   47: invokestatic 139	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   50: ldc -116
    //   52: aload_0
    //   53: iconst_1
    //   54: invokevirtual 144	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   57: pop
    //   58: aload_0
    //   59: aload_0
    //   60: ldc -111
    //   62: invokevirtual 149	com/whatsapp/util/undobar/a:findViewById	(I)Landroid/view/View;
    //   65: checkcast 151	android/widget/TextView
    //   68: putfield 153	com/whatsapp/util/undobar/a:h	Landroid/widget/TextView;
    //   71: aload_0
    //   72: aload_0
    //   73: ldc -102
    //   75: invokevirtual 149	com/whatsapp/util/undobar/a:findViewById	(I)Landroid/view/View;
    //   78: checkcast 151	android/widget/TextView
    //   81: putfield 156	com/whatsapp/util/undobar/a:i	Landroid/widget/TextView;
    //   84: aload_0
    //   85: getfield 156	com/whatsapp/util/undobar/a:i	Landroid/widget/TextView;
    //   88: new 8	com/whatsapp/util/undobar/a$2
    //   91: dup
    //   92: aload_0
    //   93: invokespecial 157	com/whatsapp/util/undobar/a$2:<init>	(Lcom/whatsapp/util/undobar/a;)V
    //   96: invokevirtual 161	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   99: aload_0
    //   100: iconst_1
    //   101: invokespecial 164	com/whatsapp/util/undobar/a:a	(Z)V
    //   104: getstatic 169	android/os/Build$VERSION:SDK_INT	I
    //   107: bipush 19
    //   109: if_icmplt +234 -> 343
    //   112: aload_1
    //   113: ldc -85
    //   115: invokevirtual 177	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   118: checkcast 179	android/view/WindowManager
    //   121: astore_3
    //   122: aload_0
    //   123: invokevirtual 183	com/whatsapp/util/undobar/a:getResources	()Landroid/content/res/Resources;
    //   126: invokevirtual 189	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   129: getfield 194	android/content/res/Configuration:orientation	I
    //   132: iconst_1
    //   133: if_icmpne +5 -> 138
    //   136: iconst_1
    //   137: istore_2
    //   138: aload_0
    //   139: iload_2
    //   140: putfield 196	com/whatsapp/util/undobar/a:p	Z
    //   143: ldc -58
    //   145: invokestatic 202	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   148: ldc -52
    //   150: iconst_1
    //   151: anewarray 49	java/lang/Class
    //   154: dup
    //   155: iconst_0
    //   156: ldc -50
    //   158: aastore
    //   159: invokevirtual 210	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   162: astore 4
    //   164: aload 4
    //   166: iconst_1
    //   167: invokevirtual 215	java/lang/reflect/Method:setAccessible	(Z)V
    //   170: aload_0
    //   171: aload 4
    //   173: aconst_null
    //   174: iconst_1
    //   175: anewarray 217	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: ldc -37
    //   182: aastore
    //   183: invokevirtual 223	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   186: checkcast 206	java/lang/String
    //   189: putfield 225	com/whatsapp/util/undobar/a:q	Ljava/lang/String;
    //   192: aload_1
    //   193: iconst_2
    //   194: newarray <illegal type>
    //   196: dup
    //   197: iconst_0
    //   198: ldc -30
    //   200: iastore
    //   201: dup
    //   202: iconst_1
    //   203: ldc -29
    //   205: iastore
    //   206: invokevirtual 231	android/content/Context:obtainStyledAttributes	([I)Landroid/content/res/TypedArray;
    //   209: astore_1
    //   210: aload_0
    //   211: aload_1
    //   212: iconst_1
    //   213: iconst_0
    //   214: invokevirtual 237	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   217: putfield 239	com/whatsapp/util/undobar/a:r	Z
    //   220: aload_1
    //   221: invokevirtual 242	android/content/res/TypedArray:recycle	()V
    //   224: getstatic 55	com/whatsapp/util/undobar/a:d	Z
    //   227: ifne +35 -> 262
    //   230: aload_0
    //   231: invokevirtual 246	com/whatsapp/util/undobar/a:getContext	()Landroid/content/Context;
    //   234: ifnonnull +28 -> 262
    //   237: new 248	java/lang/AssertionError
    //   240: dup
    //   241: invokespecial 249	java/lang/AssertionError:<init>	()V
    //   244: athrow
    //   245: astore 4
    //   247: aload_0
    //   248: aconst_null
    //   249: putfield 225	com/whatsapp/util/undobar/a:q	Ljava/lang/String;
    //   252: goto -60 -> 192
    //   255: astore_3
    //   256: aload_1
    //   257: invokevirtual 242	android/content/res/TypedArray:recycle	()V
    //   260: aload_3
    //   261: athrow
    //   262: aload_0
    //   263: invokevirtual 246	com/whatsapp/util/undobar/a:getContext	()Landroid/content/Context;
    //   266: checkcast 251	android/app/Activity
    //   269: invokevirtual 255	android/app/Activity:getWindow	()Landroid/view/Window;
    //   272: invokevirtual 261	android/view/Window:getAttributes	()Landroid/view/WindowManager$LayoutParams;
    //   275: getfield 266	android/view/WindowManager$LayoutParams:flags	I
    //   278: ldc_w 267
    //   281: iand
    //   282: ifeq +8 -> 290
    //   285: aload_0
    //   286: iconst_1
    //   287: putfield 239	com/whatsapp/util/undobar/a:r	Z
    //   290: new 269	android/util/DisplayMetrics
    //   293: dup
    //   294: invokespecial 270	android/util/DisplayMetrics:<init>	()V
    //   297: astore_1
    //   298: getstatic 169	android/os/Build$VERSION:SDK_INT	I
    //   301: bipush 16
    //   303: if_icmplt +41 -> 344
    //   306: aload_3
    //   307: invokeinterface 274 1 0
    //   312: aload_1
    //   313: invokevirtual 280	android/view/Display:getRealMetrics	(Landroid/util/DisplayMetrics;)V
    //   316: aload_0
    //   317: aload_1
    //   318: getfield 283	android/util/DisplayMetrics:widthPixels	I
    //   321: i2f
    //   322: aload_1
    //   323: getfield 286	android/util/DisplayMetrics:density	F
    //   326: fdiv
    //   327: aload_1
    //   328: getfield 289	android/util/DisplayMetrics:heightPixels	I
    //   331: i2f
    //   332: aload_1
    //   333: getfield 286	android/util/DisplayMetrics:density	F
    //   336: fdiv
    //   337: invokestatic 295	java/lang/Math:min	(FF)F
    //   340: putfield 297	com/whatsapp/util/undobar/a:s	F
    //   343: return
    //   344: aload_3
    //   345: invokeinterface 274 1 0
    //   350: aload_1
    //   351: invokevirtual 300	android/view/Display:getMetrics	(Landroid/util/DisplayMetrics;)V
    //   354: goto -38 -> 316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	a
    //   0	357	1	paramContext	Context
    //   1	139	2	bool	boolean
    //   121	1	3	localWindowManager	android.view.WindowManager
    //   255	90	3	localObject	Object
    //   162	10	4	localMethod	java.lang.reflect.Method
    //   245	1	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   143	192	245	java/lang/Throwable
    //   210	220	255	finally
  }
  
  public static a a(Activity paramActivity, CharSequence paramCharSequence, c paramc, Parcelable paramParcelable, UndoBarStyle paramUndoBarStyle, int paramInt)
  {
    a locala2 = b(paramActivity);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramActivity);
      ((ViewGroup)paramActivity.findViewById(16908290)).addView(locala1);
    }
    if (paramUndoBarStyle == null) {
      throw new IllegalArgumentException("style must not be empty.");
    }
    locala1.e = paramUndoBarStyle;
    locala1.setUndoListener(paramc);
    locala1.a(false, paramCharSequence, paramParcelable);
    locala1.o = paramInt;
    return locala1;
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity = b(paramActivity);
    if (paramActivity != null)
    {
      paramActivity.setVisibility(8);
      paramActivity.j.removeCallbacks(paramActivity.k);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.j.removeCallbacks(this.k);
    this.m = null;
    if (!paramBoolean)
    {
      clearAnimation();
      if (this.e.f == null) {
        break label52;
      }
      startAnimation(this.e.f);
    }
    for (;;)
    {
      setVisibility(8);
      return;
      label52:
      startAnimation(g);
    }
  }
  
  private void a(boolean paramBoolean, CharSequence paramCharSequence, Parcelable paramParcelable)
  {
    int i2 = 1;
    this.m = paramParcelable;
    this.n = paramCharSequence;
    this.h.setText(this.n);
    label199:
    int i1;
    if (this.e.b > 0)
    {
      this.i.setVisibility(0);
      findViewById(2131756147).setVisibility(0);
      this.i.setText(this.e.b);
      if (this.e.a > 0) {
        this.i.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(this.e.a), null, null, null);
      }
      if (this.e.c > 0) {
        findViewById(2131756145).setBackgroundResource(this.e.c);
      }
      this.j.removeCallbacks(this.k);
      if (this.e.d > 0L) {
        this.j.postDelayed(this.k, this.e.d);
      }
      if (!paramBoolean)
      {
        clearAnimation();
        if (this.e.e == null) {
          break label377;
        }
        startAnimation(this.e.e);
      }
      setVisibility(0);
      if ((Build.VERSION.SDK_INT >= 19) && (this.o != 0) && ((this.o == 1) || (this.r)))
      {
        paramCharSequence = getContext();
        paramParcelable = paramCharSequence.getResources();
        if (Build.VERSION.SDK_INT < 14) {
          break label469;
        }
        Resources localResources = paramCharSequence.getResources();
        i1 = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (i1 == 0) {
          break label405;
        }
        paramBoolean = localResources.getBoolean(i1);
        if (!"1".equals(this.q)) {
          break label387;
        }
        paramBoolean = false;
        label302:
        if (!paramBoolean) {
          break label469;
        }
        if (!this.p) {
          break label425;
        }
        paramCharSequence = "navigation_bar_height";
        i1 = paramParcelable.getIdentifier(paramCharSequence, "dimen", "android");
        if (i1 <= 0) {
          break label475;
        }
        i1 = paramParcelable.getDimensionPixelSize(i1);
      }
    }
    for (;;)
    {
      setPadding(0, 0, 0, i1);
      return;
      this.i.setVisibility(8);
      findViewById(2131756147).setVisibility(8);
      break;
      label377:
      startAnimation(f);
      break label199;
      label387:
      if (!"0".equals(this.q)) {
        break label302;
      }
      paramBoolean = true;
      break label302;
      label405:
      if (!ViewConfiguration.get(paramCharSequence).hasPermanentMenuKey())
      {
        paramBoolean = true;
        break label302;
      }
      paramBoolean = false;
      break label302;
      label425:
      i1 = i2;
      if (this.s < 600.0F) {
        if (!this.p) {
          break label463;
        }
      }
      label463:
      for (i1 = i2;; i1 = 0)
      {
        if (i1 == 0) {
          break label469;
        }
        paramCharSequence = "navigation_bar_height_landscape";
        break;
      }
      label469:
      i1 = 0;
      continue;
      label475:
      i1 = 0;
    }
  }
  
  private static a b(Activity paramActivity)
  {
    if (paramActivity == null) {}
    do
    {
      return null;
      paramActivity = paramActivity.findViewById(2131756145);
    } while (paramActivity == null);
    return (a)paramActivity.getParent();
  }
  
  private void setUndoListener(c paramc)
  {
    this.l = paramc;
  }
  
  public c getUndoListener()
  {
    return this.l;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.n = paramParcelable.getCharSequence("undo_message");
      this.m = paramParcelable.getParcelable("undo_token");
      this.e = ((UndoBarStyle)paramParcelable.getParcelable("undo_style"));
      if (paramParcelable.getInt("visible") == 0) {
        a(true, this.n, this.m);
      }
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("undo_message", this.n);
    localBundle.putParcelable("undo_token", this.m);
    localBundle.putParcelable("undo_style", this.e);
    localBundle.putInt("visible", getVisibility());
    return localBundle;
  }
  
  public static abstract interface a
    extends a.c
  {}
  
  public static final class b
  {
    public final Activity a;
    public CharSequence b;
    public Parcelable c;
    public a.c d;
    private UndoBarStyle e;
    private long f;
    private int g = -1;
    
    public b(Activity paramActivity)
    {
      this.a = paramActivity;
    }
    
    public final a a()
    {
      if ((this.d == null) && (this.e == null)) {
        this.e = a.c;
      }
      if (this.e == null) {
        this.e = a.a;
      }
      if (this.b == null) {
        this.b = "";
      }
      if (this.f > 0L) {
        this.e.d = this.f;
      }
      return a.a(this.a, this.b, this.d, this.c, this.e, this.g);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(Parcelable paramParcelable);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/undobar/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */