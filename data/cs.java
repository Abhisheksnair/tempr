package com.whatsapp.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.RawContacts;
import android.support.design.widget.AppBarLayout.b;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.b.a.f.c;
import com.whatsapp.acm;
import com.whatsapp.and;
import com.whatsapp.atu;
import com.whatsapp.aus;
import com.whatsapp.av;
import com.whatsapp.contact.ContactProvider;
import com.whatsapp.contact.sync.m;
import com.whatsapp.contact.sync.n;
import com.whatsapp.di;
import com.whatsapp.emoji.c;
import com.whatsapp.protocol.j;
import com.whatsapp.qz;
import com.whatsapp.rg;
import com.whatsapp.rh;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.be;
import com.whatsapp.util.x;
import com.whatsapp.va;
import com.whatsapp.va.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class cs
{
  public static final String[] b = { "wa_contacts._id", "wa_contacts.jid", "is_whatsapp_user", "status", "number", "raw_contact_id", "display_name", "phone_type", "phone_label", "unseen_msg_count", "photo_ts", "thumb_ts", "photo_id_timestamp", "given_name", "family_name", "wa_name", "sort_name", "status_timestamp", "nickname", "company", "title", "status_autodownload_disabled", "keep_timestamp", "is_spam_reported", "verified_name", "expires" };
  protected String A;
  public Locale B;
  public boolean C;
  public String D;
  public long E;
  public boolean F;
  private final d G = d.a();
  private final ad H = ad.a();
  private final di I = di.a();
  private final e J = e.a();
  private final and K = and.a();
  private final acm L = acm.a();
  private final atu M = atu.a();
  private final rh N = rh.a();
  private final va a = va.a();
  public long c = -1L;
  public a d = null;
  public String e;
  public Integer f = null;
  public String g;
  public boolean h;
  public boolean i = false;
  @Deprecated
  public String j = null;
  public transient boolean k = true;
  public int l;
  public int m;
  public long n;
  public String o;
  public String p;
  public String q;
  public String r;
  @Deprecated
  public int s;
  public String t;
  public String u;
  public long v;
  public String w;
  public String x;
  public String y;
  Map<Class<? extends AppBarLayout.b>, AppBarLayout.b> z;
  
  private cs(Cursor paramCursor)
  {
    this.t = paramCursor.getString(1);
    this.u = paramCursor.getString(3);
    this.v = paramCursor.getLong(17);
    this.c = paramCursor.getLong(0);
    this.f = Integer.valueOf(paramCursor.getInt(7));
    this.g = paramCursor.getString(8);
    Object localObject = paramCursor.getString(4);
    long l1 = paramCursor.getLong(5);
    if (((l1 > 0L) || (l1 == -2L)) && (localObject != null) && (n.a((String)localObject)))
    {
      this.d = new a(l1, (String)localObject);
      localObject = paramCursor.getString(6);
      if ((this.d != null) || (d()) || (j.b(this.t))) {
        break label571;
      }
      this.D = ((String)localObject);
      label275:
      if (paramCursor.getInt(2) != 1) {
        break label580;
      }
      bool1 = true;
      label288:
      this.h = bool1;
      this.s = paramCursor.getInt(9);
      this.l = paramCursor.getInt(10);
      this.m = paramCursor.getInt(11);
      this.n = paramCursor.getLong(12);
      this.o = paramCursor.getString(13);
      this.p = paramCursor.getString(14);
      this.q = paramCursor.getString(15);
      this.r = paramCursor.getString(16);
      this.w = paramCursor.getString(18);
      this.x = paramCursor.getString(19);
      this.y = paramCursor.getString(20);
      if (paramCursor.getInt(21) != 1) {
        break label585;
      }
      bool1 = true;
      label439:
      this.C = bool1;
      this.E = paramCursor.getLong(22);
      if (paramCursor.getInt(23) != 1) {
        break label590;
      }
    }
    label571:
    label580:
    label585:
    label590:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.F = bool1;
      String str = paramCursor.getString(24);
      localObject = str;
      if (str != null)
      {
        localObject = str;
        if (!paramCursor.isNull(25))
        {
          l1 = paramCursor.getLong(25);
          localObject = str;
          if (l1 > 0L)
          {
            localObject = str;
            if (l1 <= System.currentTimeMillis() / 1000L) {
              localObject = null;
            }
          }
        }
      }
      this.A = ((String)localObject);
      return;
      if (localObject == null) {
        break;
      }
      this.j = ((String)localObject);
      break;
      this.e = ((String)localObject);
      break label275;
      bool1 = false;
      break label288;
      bool1 = false;
      break label439;
    }
  }
  
  public cs(n paramn)
  {
    this(paramn.c, paramn.a, paramn.b, paramn.d, paramn.e);
    this.r = paramn.a(this.K);
  }
  
  public cs(a parama, String paramString1, int paramInt, String paramString2)
  {
    this.d = parama;
    this.e = paramString1;
    this.f = Integer.valueOf(paramInt);
    this.g = paramString2;
  }
  
  public cs(String paramString)
  {
    this.t = paramString;
    this.h = true;
    this.d = null;
  }
  
  private cs(String paramString1, long paramLong, String paramString2, int paramInt, String paramString3)
  {
    this(new a(paramLong, paramString1), paramString2, paramInt, paramString3);
  }
  
  private cs(String paramString1, boolean paramBoolean, String paramString2, long paramLong, String paramString3, int paramInt, String paramString4)
  {
    this.t = paramString1;
    this.h = paramBoolean;
    this.e = paramString3;
    if (((paramLong > 0L) || (paramLong == -2L)) && (paramString2 != null) && (n.a(paramString2))) {
      this.d = new a(paramLong, paramString2);
    }
    this.f = Integer.valueOf(paramInt);
    this.g = paramString4;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, float paramFloat)
  {
    Drawable localDrawable = u.a().getResources().getDrawable(paramInt1);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localDrawable.setBounds(0, 0, paramInt2, paramInt2);
    if ((localDrawable instanceof BitmapDrawable))
    {
      Paint localPaint = new Paint();
      RectF localRectF = new RectF(0.0F, 0.0F, paramInt2, paramInt2);
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-1);
      if (paramFloat >= 0.0F) {
        localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
      }
      for (;;)
      {
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        localCanvas.drawBitmap(((BitmapDrawable)localDrawable).getBitmap(), null, localRectF, localPaint);
        return localBitmap;
        localCanvas.drawArc(localRectF, 0.0F, 360.0F, true, localPaint);
      }
    }
    localDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  public static cs a(Cursor paramCursor)
  {
    boolean bool = true;
    Object localObject = paramCursor.getString(1);
    if (paramCursor.getInt(2) == 1) {}
    for (;;)
    {
      localObject = new cs((String)localObject, bool, paramCursor.getString(3), paramCursor.getLong(4), paramCursor.getString(5), paramCursor.getInt(6), paramCursor.getString(7));
      ((cs)localObject).c = paramCursor.getLong(0);
      return (cs)localObject;
      bool = false;
    }
  }
  
  private InputStream a(ContentResolver paramContentResolver, boolean paramBoolean)
  {
    Object localObject = null;
    Uri localUri = c(paramContentResolver);
    if ((localUri == null) || ((paramBoolean) && (Build.VERSION.SDK_INT >= 14))) {}
    try
    {
      localObject = ContactsContract.Contacts.class.getDeclaredMethod("openContactPhotoInputStream", new Class[] { ContentResolver.class, Uri.class, Boolean.TYPE });
      ((Method)localObject).setAccessible(true);
      localObject = (InputStream)((Method)localObject).invoke(null, new Object[] { paramContentResolver, localUri, Boolean.valueOf(true) });
      return (InputStream)localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.e(localIllegalAccessException);
      return ContactsContract.Contacts.openContactPhotoInputStream(paramContentResolver, localUri);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
    catch (SecurityException localSecurityException)
    {
      for (;;) {}
    }
  }
  
  public static String a(String paramString)
  {
    paramString = "+" + paramString;
    try
    {
      Object localObject = com.google.b.a.f.a();
      localObject = ((com.google.b.a.f)localObject).a(((com.google.b.a.f)localObject).a(paramString, "ZZ"), f.c.b);
      return (String)localObject;
    }
    catch (Exception localException)
    {
      Log.e("contact/formatter-exception num:" + paramString + " " + localException.getMessage());
      return paramString;
    }
    catch (ExceptionInInitializerError localExceptionInInitializerError)
    {
      Log.e("contact/formatter-init-exception num:" + paramString + " " + localExceptionInInitializerError.getMessage());
    }
    return paramString;
  }
  
  public static void a(Collection<cs> paramCollection, String paramString)
  {
    int i1 = paramCollection.size();
    Log.i(paramString + "/count " + i1);
    if (av.m()) {}
    for (;;)
    {
      return;
      if (i1 < 5000)
      {
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
          paramCollection.next();
        }
      }
    }
  }
  
  public static boolean a(List<cs> paramList, e parame)
  {
    boolean bool2;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      boolean bool1 = false;
      bool2 = bool1;
      if (paramList.hasNext())
      {
        if ((parame.b((cs)paramList.next())) || (bool1)) {}
        for (bool1 = true;; bool1 = false) {
          break;
        }
      }
    }
    else
    {
      bool2 = false;
    }
    return bool2;
  }
  
  public static Bitmap b(int paramInt)
  {
    SparseArray localSparseArray = com.whatsapp.c.a.a().e;
    Bitmap localBitmap = (Bitmap)localSparseArray.get(paramInt);
    if (localBitmap != null) {
      return localBitmap;
    }
    localBitmap = a(paramInt, u.a().getResources().getDimensionPixelSize(2131362090), u.a().getResources().getDimension(2131361833));
    localSparseArray.put(paramInt, localBitmap);
    return localBitmap;
  }
  
  public static cs b(Cursor paramCursor)
  {
    return new cs(paramCursor);
  }
  
  public static String b(String paramString)
  {
    if (paramString == null)
    {
      Log.w("contact/phonenumber/jid/null");
      localObject = null;
    }
    int i1;
    do
    {
      return (String)localObject;
      i1 = paramString.indexOf('@');
      localObject = paramString;
    } while (i1 == -1);
    if (qz.g(paramString)) {
      return paramString.substring(paramString.indexOf("-") + 1, paramString.lastIndexOf("@"));
    }
    String str = paramString.substring(0, i1);
    Object localObject = str;
    if (PhoneNumberUtils.isGlobalPhoneNumber(str)) {
      if ((qz.e(paramString)) || (e.b(paramString))) {
        break label93;
      }
    }
    label93:
    for (localObject = a(str);; localObject = "+" + str) {
      return (String)localObject;
    }
  }
  
  private Uri c(ContentResolver paramContentResolver)
  {
    Uri localUri1 = null;
    Uri localUri2 = b(paramContentResolver);
    if (localUri2 != null) {}
    try
    {
      localUri1 = ContactsContract.Contacts.lookupContact(paramContentResolver, localUri2);
      return localUri1;
    }
    catch (IllegalArgumentException paramContentResolver)
    {
      Log.e(paramContentResolver);
      return null;
    }
    catch (IllegalStateException paramContentResolver)
    {
      Log.e(paramContentResolver);
    }
    return null;
  }
  
  public static File c(String paramString)
  {
    File localFile = new File(u.a().getFilesDir(), "Avatars");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile, paramString + ".j");
  }
  
  public static boolean d(String paramString)
  {
    return qz.g(paramString);
  }
  
  public static boolean e(String paramString)
  {
    return (j.b(paramString)) || (j.a(paramString));
  }
  
  private Uri r()
  {
    if ((this.d == null) || (this.d.a == -2L) || (this.d.a < 0L)) {
      return null;
    }
    return ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, this.d.a);
  }
  
  private String s()
  {
    if (this.d != null) {
      return this.d.toString();
    }
    return this.t;
  }
  
  public final Bitmap a(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (Bitmap localBitmap = b(e()); paramInt == 0; localBitmap = BitmapFactory.decodeResource(u.a().getResources(), e())) {
      return localBitmap;
    }
    return Bitmap.createScaledBitmap(localBitmap, paramInt, paramInt, true);
  }
  
  public final Bitmap a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = this.I.a(a(paramInt, paramFloat));
      if (localObject == null) {}
    }
    Bitmap localBitmap;
    do
    {
      do
      {
        return (Bitmap)localObject;
        localBitmap = c(paramInt, paramFloat);
        localObject = localBitmap;
      } while (!paramBoolean);
      localObject = localBitmap;
    } while (localBitmap == null);
    Object localObject = this.I;
    String str = a(paramInt, paramFloat);
    ((di)localObject).a.b.a(str, localBitmap);
    return localBitmap;
  }
  
  public final Uri a(ContentResolver paramContentResolver)
  {
    Object localObject1 = b(paramContentResolver);
    if (localObject1 == null) {}
    do
    {
      return null;
      paramContentResolver = paramContentResolver.query((Uri)localObject1, null, null, null, null);
    } while (paramContentResolver == null);
    try
    {
      if (paramContentResolver.moveToNext())
      {
        localObject1 = paramContentResolver.getString(paramContentResolver.getColumnIndex("lookup"));
        localObject1 = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_VCARD_URI, (String)localObject1);
        return (Uri)localObject1;
      }
      return null;
    }
    finally
    {
      paramContentResolver.close();
    }
  }
  
  public InputStream a(boolean paramBoolean)
  {
    ContentResolver localContentResolver = u.a().getContentResolver();
    InputStream localInputStream = a(localContentResolver, paramBoolean);
    if (localInputStream == null)
    {
      Object localObject2 = this.J.b;
      Object localObject1;
      if ((this == null) || (this.d == null) || (this.t == null) || (this.e == null)) {
        localObject1 = new ArrayList();
      }
      for (;;)
      {
        Log.d("wacontact/getphotofast/" + this.t + " similarCount=" + ((ArrayList)localObject1).size());
        localObject2 = ((ArrayList)localObject1).iterator();
        localObject1 = localInputStream;
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (Long)((Iterator)localObject2).next();
          Log.d("wacontact/getphotofast/rawid " + localObject1);
          localInputStream = new cs(this.d.b, ((Long)localObject1).longValue(), this.e, 0, null).a(localContentResolver, paramBoolean);
          localObject1 = localInputStream;
          if (localInputStream != null) {
            localObject1 = localInputStream;
          }
        }
        return (InputStream)localObject1;
        long l1 = System.currentTimeMillis();
        localObject1 = new ArrayList();
        localObject2 = ((ct)localObject2).c;
        Uri localUri = ContactProvider.a;
        String str1 = this.t;
        String str2 = this.e;
        long l2 = this.d.a;
        localObject2 = ((ct.b)localObject2).a(localUri, new String[] { "raw_contact_id" }, "wa_contacts.jid = ? AND display_name = ? AND raw_contact_id != ?", new String[] { str1, str2, String.valueOf(l2) }, "raw_contact_id ASC");
        if (localObject2 == null)
        {
          Log.e("unable to get ids of similar contacts " + this);
        }
        else
        {
          while (((Cursor)localObject2).moveToNext()) {
            ((ArrayList)localObject1).add(Long.valueOf(((Cursor)localObject2).getLong(0)));
          }
          ((Cursor)localObject2).close();
          Log.i("found " + ((ArrayList)localObject1).size() + " similar contacts to " + this + " | time: " + (System.currentTimeMillis() - l1));
        }
      }
    }
    return localInputStream;
  }
  
  public final CharSequence a(Resources paramResources)
  {
    if (this.f != null)
    {
      if ((this.f.intValue() == 0) && (this.g != null)) {
        return this.g;
      }
      return paramResources.getString(ContactsContract.CommonDataKinds.Phone.getTypeLabelResource(this.f.intValue()));
    }
    return null;
  }
  
  public final String a(int paramInt, float paramFloat)
  {
    return s() + "_" + paramInt + "_" + paramFloat;
  }
  
  public final String a(Context paramContext)
  {
    if ("status@broadcast".equals(this.t)) {
      paramContext = paramContext.getString(2131297237);
    }
    String str;
    do
    {
      return paramContext;
      if ("broadcast".equals(this.t)) {
        return paramContext.getString(2131296362);
      }
      if (f()) {
        return this.A;
      }
      if (!TextUtils.isEmpty(this.e)) {
        return this.e;
      }
      if (d()) {
        return paramContext.getString(2131297018);
      }
      if (j.b(this.t))
      {
        int i1 = this.N.a(this.t).c();
        return String.format(u.a.a(2131230720, i1), new Object[] { Integer.valueOf(i1) });
      }
      str = this.H.n(this.t);
      paramContext = str;
    } while (!TextUtils.isEmpty(str));
    return "‪" + b(this.t) + "‬";
  }
  
  public final String a(Context paramContext, aus paramaus, Object... paramVarArgs)
  {
    return x.a(paramContext, this.G, paramaus, this.t, 2131296563, paramVarArgs);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a.a(this.t))
    {
      this.a.c().a(paramInt1, paramInt2);
      return;
    }
    this.l = paramInt1;
    this.m = paramInt2;
    this.n = System.currentTimeMillis();
    this.J.c(this);
  }
  
  public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 != null) {}
    try
    {
      MediaFileUtils.a(paramArrayOfByte1, b());
      if (paramArrayOfByte2 != null) {
        MediaFileUtils.a(paramArrayOfByte2, c());
      }
      return;
    }
    catch (IOException paramArrayOfByte1)
    {
      Log.d("updatePhotoFiles", paramArrayOfByte1);
    }
  }
  
  public boolean a()
  {
    if (this.a.a(this.t)) {
      this.a.c();
    }
    while (this.n + 604800000L >= System.currentTimeMillis()) {
      return false;
    }
    return true;
  }
  
  public final boolean a(n paramn, m paramm)
  {
    Object localObject = null;
    boolean bool2 = false;
    a locala = new a(paramn.a, paramn.c);
    if ((this.d == null) || (!this.d.equals(locala)))
    {
      this.d = locala;
      bool2 = true;
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramn.b))
    {
      bool1 = bool2;
      if (!TextUtils.equals(this.e, paramn.b))
      {
        this.e = paramn.b;
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (paramm != null)
    {
      bool2 = bool1;
      if (!TextUtils.isEmpty(paramm.b))
      {
        bool2 = bool1;
        if (!TextUtils.equals(this.o, paramm.b))
        {
          this.o = paramm.b;
          bool2 = true;
        }
      }
    }
    boolean bool3 = bool2;
    if (paramm != null)
    {
      bool3 = bool2;
      if (!TextUtils.isEmpty(paramm.c))
      {
        bool3 = bool2;
        if (!TextUtils.equals(this.p, paramm.c))
        {
          this.p = paramm.c;
          bool3 = true;
        }
      }
    }
    if (this.f.intValue() != paramn.d)
    {
      this.f = Integer.valueOf(paramn.d);
      if (this.f.intValue() != 0)
      {
        this.g = null;
        bool1 = true;
        if (((!paramn.f) && (paramm != null)) || (TextUtils.isEmpty(paramn.a(this.K))) || (TextUtils.equals(this.r, paramn.a(this.K)))) {
          break label479;
        }
        this.r = paramn.a(this.K);
        bool2 = true;
      }
    }
    label479:
    do
    {
      do
      {
        bool1 = bool2;
        if (paramm != null)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramm.d))
          {
            bool1 = bool2;
            if (!TextUtils.equals(this.w, paramm.d))
            {
              this.w = paramm.d;
              bool1 = true;
            }
          }
        }
        bool2 = bool1;
        if (paramm != null)
        {
          bool2 = bool1;
          if (!TextUtils.isEmpty(paramm.e))
          {
            bool2 = bool1;
            if (!TextUtils.equals(this.x, paramm.e))
            {
              this.x = paramm.e;
              bool2 = true;
            }
          }
        }
        if ((paramm == null) || (TextUtils.isEmpty(paramm.f)) || (TextUtils.equals(this.y, paramm.f))) {
          break label622;
        }
        this.y = paramm.f;
        return true;
        this.g = paramn.e;
        bool1 = true;
        break;
        bool1 = bool3;
        if (this.f.intValue() != 0) {
          break;
        }
        bool1 = bool3;
        if (TextUtils.equals(this.g, paramn.e)) {
          break;
        }
        this.g = paramn.e;
        bool1 = true;
        break;
        bool2 = bool1;
      } while (paramm == null);
      bool2 = bool1;
    } while (Build.VERSION.SDK_INT >= 11);
    if ((!TextUtils.isEmpty(paramm.h)) && (!TextUtils.isEmpty(paramm.g))) {
      paramn = paramm.h + " " + paramm.g;
    }
    for (;;)
    {
      bool2 = bool1;
      if (TextUtils.isEmpty(paramn)) {
        break;
      }
      bool2 = bool1;
      if (TextUtils.equals(this.r, paramn)) {
        break;
      }
      this.r = paramn;
      bool2 = true;
      break;
      if (!TextUtils.isEmpty(paramm.h))
      {
        paramn = paramm.h;
      }
      else
      {
        paramn = (n)localObject;
        if (!TextUtils.isEmpty(paramm.g)) {
          paramn = paramm.g;
        }
      }
    }
    label622:
    return bool2;
  }
  
  public final boolean a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return true;
    }
    String str;
    if (!TextUtils.isEmpty(this.e)) {
      str = c.a(this.e);
    }
    while ((be.a(str, paramArrayList)) || (be.a(this.w, paramArrayList)) || (be.a(this.A, paramArrayList)) || (be.a(this.x, paramArrayList)) || (be.a(this.y, paramArrayList)))
    {
      return true;
      if (j.b(this.t)) {
        str = this.N.g(this.t);
      } else {
        str = b(this.t);
      }
    }
    if ((!j.b(this.t)) && (!d()))
    {
      i1 = this.t.indexOf('@');
      if (i1 > 0)
      {
        str = this.t.substring(0, i1);
        paramArrayList = paramArrayList.iterator();
        do
        {
          if (!paramArrayList.hasNext()) {
            break;
          }
        } while (str.contains((String)paramArrayList.next()));
      }
    }
    for (int i1 = 0;; i1 = 1) {
      return i1 != 0;
    }
  }
  
  public final Bitmap b(int paramInt, float paramFloat)
  {
    return this.I.a(a(paramInt, paramFloat));
  }
  
  public final Bitmap b(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap2 = c(paramInt1, paramInt2);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = b(e());
    }
    return localBitmap1;
  }
  
  public final Uri b(ContentResolver paramContentResolver)
  {
    if (this.M.a("android.permission.READ_CONTACTS") != 0) {}
    while (r() == null) {
      return null;
    }
    return ContactsContract.RawContacts.getContactLookupUri(paramContentResolver, r());
  }
  
  public File b()
  {
    if (this.a.a(this.t)) {
      return this.a.c().b();
    }
    String str = this.t;
    File localFile = new File(u.a().getCacheDir(), "Profile Pictures");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    int i1 = str.indexOf("@");
    if (i1 > 0) {
      return new File(localFile, str.substring(0, i1) + ".jpg");
    }
    return new File(localFile, str + ".jpg");
  }
  
  public final InputStream b(boolean paramBoolean)
  {
    Object localObject = null;
    File localFile;
    if (this.k)
    {
      if (!paramBoolean) {
        break label117;
      }
      localFile = b();
      localObject = localFile;
      if (!localFile.exists())
      {
        localFile = c();
        localObject = localFile;
        if (this.l > 0)
        {
          localObject = localFile;
          if (this.M.b(Environment.getExternalStorageState()))
          {
            Log.e("wacontact/getphotostream/" + this.t + " full file missing id:" + this.l);
            this.l = 0;
            localObject = localFile;
          }
        }
      }
    }
    while (((File)localObject).exists())
    {
      label117:
      try
      {
        localObject = new FileInputStream((File)localObject);
        return (InputStream)localObject;
      }
      catch (FileNotFoundException localFileNotFoundException) {}
      localFile = c();
      localObject = localFile;
      if (!localFile.exists())
      {
        localFile = b();
        localObject = localFile;
        if (this.m > 0)
        {
          Log.e("wacontact/getphotostream/" + this.t + " thumb file missing id:" + this.m);
          this.m = 0;
          localObject = localFile;
        }
      }
    }
    return a(paramBoolean);
  }
  
  public final String b(Context paramContext)
  {
    if ("status@broadcast".equals(this.t)) {
      paramContext = paramContext.getString(2131297237);
    }
    String str;
    do
    {
      return paramContext;
      if ("broadcast".equals(this.t)) {
        return paramContext.getString(2131296362);
      }
      if (f()) {
        return this.A;
      }
      if (!TextUtils.isEmpty(this.e)) {
        return this.e;
      }
      if (!TextUtils.isEmpty(this.D)) {
        return this.D;
      }
      if (d()) {
        return paramContext.getString(2131297018);
      }
      if (j.b(this.t))
      {
        int i1 = this.N.a(this.t).c();
        return String.format(u.a.a(2131230720, i1), new Object[] { Integer.valueOf(i1) });
      }
      str = this.H.n(this.t);
      paramContext = str;
    } while (!TextUtils.isEmpty(str));
    return "‪" + b(this.t) + "‬";
  }
  
  /* Error */
  public final Bitmap c(int paramInt, float paramFloat)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_1
    //   4: istore 4
    //   6: iload_1
    //   7: i2f
    //   8: fstore_3
    //   9: fload_3
    //   10: invokestatic 1014	com/whatsapp/aoa:a	()Lcom/whatsapp/aoa;
    //   13: getfield 1016	com/whatsapp/aoa:a	F
    //   16: ldc_w 1017
    //   19: fmul
    //   20: fcmpl
    //   21: iflt +203 -> 224
    //   24: aload_0
    //   25: getfield 151	com/whatsapp/data/cs:k	Z
    //   28: ifeq +1184 -> 1212
    //   31: aload_0
    //   32: iload 4
    //   34: invokevirtual 1019	com/whatsapp/data/cs:b	(Z)Ljava/io/InputStream;
    //   37: astore 5
    //   39: aload_0
    //   40: getfield 222	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   43: ifnull +89 -> 132
    //   46: aload_0
    //   47: invokevirtual 255	com/whatsapp/data/cs:d	()Z
    //   50: ifeq +13 -> 63
    //   53: aload_0
    //   54: getfield 222	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   57: invokestatic 629	com/whatsapp/qz:g	(Ljava/lang/String;)Z
    //   60: ifeq +37 -> 97
    //   63: aload_0
    //   64: invokevirtual 255	com/whatsapp/data/cs:d	()Z
    //   67: ifne +65 -> 132
    //   70: aload_0
    //   71: getfield 222	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   74: invokestatic 259	com/whatsapp/protocol/j:b	(Ljava/lang/String;)Z
    //   77: ifne +55 -> 132
    //   80: aload_0
    //   81: getfield 222	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   84: invokestatic 651	com/whatsapp/data/e:b	(Ljava/lang/String;)Z
    //   87: ifne +45 -> 132
    //   90: aload_0
    //   91: getfield 263	com/whatsapp/data/cs:h	Z
    //   94: ifeq +38 -> 132
    //   97: iload 4
    //   99: ifeq +131 -> 230
    //   102: aload_0
    //   103: getfield 267	com/whatsapp/data/cs:l	I
    //   106: ifeq +10 -> 116
    //   109: aload_0
    //   110: invokevirtual 1021	com/whatsapp/data/cs:a	()Z
    //   113: ifeq +19 -> 132
    //   116: aload_0
    //   117: getfield 200	com/whatsapp/data/cs:L	Lcom/whatsapp/acm;
    //   120: aload_0
    //   121: getfield 222	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   124: aload_0
    //   125: getfield 267	com/whatsapp/data/cs:l	I
    //   128: iconst_1
    //   129: invokevirtual 1024	com/whatsapp/acm:a	(Ljava/lang/String;II)V
    //   132: aload 5
    //   134: ifnull +933 -> 1067
    //   137: new 1026	android/graphics/BitmapFactory$Options
    //   140: dup
    //   141: invokespecial 1027	android/graphics/BitmapFactory$Options:<init>	()V
    //   144: astore 8
    //   146: aload 8
    //   148: iconst_1
    //   149: putfield 1030	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   152: aload 5
    //   154: aconst_null
    //   155: aload 8
    //   157: invokestatic 1034	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   160: pop
    //   161: aload 5
    //   163: invokevirtual 1035	java/io/InputStream:close	()V
    //   166: aload_0
    //   167: iload 4
    //   169: invokevirtual 1019	com/whatsapp/data/cs:b	(Z)Ljava/io/InputStream;
    //   172: astore 6
    //   174: aload 6
    //   176: astore 5
    //   178: aload 5
    //   180: ifnonnull +182 -> 362
    //   183: new 503	java/lang/StringBuilder
    //   186: dup
    //   187: ldc_w 769
    //   190: invokespecial 507	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   193: aload_0
    //   194: getfield 222	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   197: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 1037
    //   203: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 541	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   212: aload 5
    //   214: ifnull +8 -> 222
    //   217: aload 5
    //   219: invokevirtual 1035	java/io/InputStream:close	()V
    //   222: aconst_null
    //   223: areturn
    //   224: iconst_0
    //   225: istore 4
    //   227: goto -203 -> 24
    //   230: aload_0
    //   231: getfield 269	com/whatsapp/data/cs:m	I
    //   234: ifeq +10 -> 244
    //   237: aload_0
    //   238: invokevirtual 1021	com/whatsapp/data/cs:a	()Z
    //   241: ifeq -109 -> 132
    //   244: aload_0
    //   245: getfield 200	com/whatsapp/data/cs:L	Lcom/whatsapp/acm;
    //   248: aload_0
    //   249: getfield 222	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   252: aload_0
    //   253: getfield 269	com/whatsapp/data/cs:m	I
    //   256: iconst_2
    //   257: invokevirtual 1024	com/whatsapp/acm:a	(Ljava/lang/String;II)V
    //   260: goto -128 -> 132
    //   263: astore 7
    //   265: aconst_null
    //   266: astore 6
    //   268: new 503	java/lang/StringBuilder
    //   271: dup
    //   272: ldc_w 1039
    //   275: invokespecial 507	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   278: aload 7
    //   280: invokevirtual 1040	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   283: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 541	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   292: aload 5
    //   294: ifnull +8 -> 302
    //   297: aload 5
    //   299: invokevirtual 1035	java/io/InputStream:close	()V
    //   302: aload 6
    //   304: ifnull +8 -> 312
    //   307: aload 6
    //   309: invokevirtual 1043	android/graphics/Bitmap:recycle	()V
    //   312: aconst_null
    //   313: areturn
    //   314: astore 6
    //   316: new 503	java/lang/StringBuilder
    //   319: dup
    //   320: ldc_w 769
    //   323: invokespecial 507	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   326: aload_0
    //   327: getfield 222	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   330: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: ldc_w 1045
    //   336: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 541	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   345: aload 6
    //   347: invokestatic 493	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   350: aload 5
    //   352: ifnull +8 -> 360
    //   355: aload 5
    //   357: invokevirtual 1035	java/io/InputStream:close	()V
    //   360: aconst_null
    //   361: areturn
    //   362: aload 8
    //   364: aload 8
    //   366: getfield 1048	android/graphics/BitmapFactory$Options:outWidth	I
    //   369: iload_1
    //   370: idiv
    //   371: aload 8
    //   373: getfield 1051	android/graphics/BitmapFactory$Options:outHeight	I
    //   376: iload_1
    //   377: idiv
    //   378: invokestatic 1057	java/lang/Math:max	(II)I
    //   381: putfield 1060	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   384: aload 8
    //   386: iconst_1
    //   387: putfield 1063	android/graphics/BitmapFactory$Options:inDither	Z
    //   390: aload 8
    //   392: iconst_0
    //   393: putfield 1030	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   396: aload 8
    //   398: iconst_0
    //   399: putfield 1066	android/graphics/BitmapFactory$Options:inScaled	Z
    //   402: aload 8
    //   404: getstatic 352	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   407: putfield 1069	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   410: aload 8
    //   412: iconst_1
    //   413: putfield 1072	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   416: aload 8
    //   418: iconst_1
    //   419: putfield 1075	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   422: aload 5
    //   424: invokestatic 1080	a/a/a/a/d:a	(Ljava/io/InputStream;)[B
    //   427: astore 6
    //   429: aload 6
    //   431: iconst_0
    //   432: aload 6
    //   434: arraylength
    //   435: aload 8
    //   437: invokestatic 1084	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   440: astore 6
    //   442: aload 6
    //   444: ifnonnull +112 -> 556
    //   447: aload 5
    //   449: astore 8
    //   451: aload 6
    //   453: astore 9
    //   455: new 503	java/lang/StringBuilder
    //   458: dup
    //   459: ldc_w 769
    //   462: invokespecial 507	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   465: aload_0
    //   466: getfield 222	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   469: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: ldc_w 1086
    //   475: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokestatic 541	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   484: aload 5
    //   486: ifnull +8 -> 494
    //   489: aload 5
    //   491: invokevirtual 1035	java/io/InputStream:close	()V
    //   494: aload 6
    //   496: ifnull +8 -> 504
    //   499: aload 6
    //   501: invokevirtual 1043	android/graphics/Bitmap:recycle	()V
    //   504: aconst_null
    //   505: areturn
    //   506: astore 6
    //   508: new 503	java/lang/StringBuilder
    //   511: dup
    //   512: ldc_w 769
    //   515: invokespecial 507	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   518: aload_0
    //   519: getfield 222	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   522: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: ldc_w 1088
    //   528: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   534: aload 6
    //   536: invokestatic 924	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   539: aload 6
    //   541: invokestatic 493	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   544: aload 5
    //   546: ifnull +8 -> 554
    //   549: aload 5
    //   551: invokevirtual 1035	java/io/InputStream:close	()V
    //   554: aconst_null
    //   555: areturn
    //   556: aload 5
    //   558: astore 8
    //   560: aload 6
    //   562: astore 9
    //   564: iload_1
    //   565: iload_1
    //   566: getstatic 352	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   569: invokestatic 358	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   572: astore 10
    //   574: aload 5
    //   576: astore 8
    //   578: aload 6
    //   580: astore 9
    //   582: new 360	android/graphics/Canvas
    //   585: dup
    //   586: aload 10
    //   588: invokespecial 363	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   591: astore 11
    //   593: aload 5
    //   595: astore 8
    //   597: aload 6
    //   599: astore 9
    //   601: new 373	android/graphics/Paint
    //   604: dup
    //   605: invokespecial 374	android/graphics/Paint:<init>	()V
    //   608: astore 12
    //   610: aload 5
    //   612: astore 8
    //   614: aload 6
    //   616: astore 9
    //   618: new 376	android/graphics/RectF
    //   621: dup
    //   622: fconst_0
    //   623: fconst_0
    //   624: iload_1
    //   625: i2f
    //   626: iload_1
    //   627: i2f
    //   628: invokespecial 379	android/graphics/RectF:<init>	(FFFF)V
    //   631: astore 7
    //   633: aload 5
    //   635: astore 8
    //   637: aload 6
    //   639: astore 9
    //   641: aload 12
    //   643: iconst_1
    //   644: invokevirtual 383	android/graphics/Paint:setAntiAlias	(Z)V
    //   647: aload 5
    //   649: astore 8
    //   651: aload 6
    //   653: astore 9
    //   655: aload 12
    //   657: iconst_1
    //   658: invokevirtual 386	android/graphics/Paint:setDither	(Z)V
    //   661: aload 5
    //   663: astore 8
    //   665: aload 6
    //   667: astore 9
    //   669: aload 12
    //   671: iconst_1
    //   672: invokevirtual 389	android/graphics/Paint:setFilterBitmap	(Z)V
    //   675: aload 5
    //   677: astore 8
    //   679: aload 6
    //   681: astore 9
    //   683: aload 11
    //   685: iconst_0
    //   686: iconst_0
    //   687: iconst_0
    //   688: iconst_0
    //   689: invokevirtual 392	android/graphics/Canvas:drawARGB	(IIII)V
    //   692: aload 5
    //   694: astore 8
    //   696: aload 6
    //   698: astore 9
    //   700: aload 12
    //   702: iconst_m1
    //   703: invokevirtual 396	android/graphics/Paint:setColor	(I)V
    //   706: fload_2
    //   707: fconst_0
    //   708: fcmpl
    //   709: ifne +181 -> 890
    //   712: aload 5
    //   714: astore 8
    //   716: aload 6
    //   718: astore 9
    //   720: aload 11
    //   722: aload 7
    //   724: aload 12
    //   726: invokevirtual 1092	android/graphics/Canvas:drawRect	(Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   729: aload 5
    //   731: astore 8
    //   733: aload 6
    //   735: astore 9
    //   737: aload 12
    //   739: new 402	android/graphics/PorterDuffXfermode
    //   742: dup
    //   743: getstatic 408	android/graphics/PorterDuff$Mode:SRC_IN	Landroid/graphics/PorterDuff$Mode;
    //   746: invokespecial 411	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   749: invokevirtual 415	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   752: pop
    //   753: aload 5
    //   755: astore 8
    //   757: aload 6
    //   759: astore 9
    //   761: new 376	android/graphics/RectF
    //   764: dup
    //   765: fconst_0
    //   766: fconst_0
    //   767: iload_1
    //   768: i2f
    //   769: iload_1
    //   770: i2f
    //   771: invokespecial 379	android/graphics/RectF:<init>	(FFFF)V
    //   774: astore 13
    //   776: aload 5
    //   778: astore 8
    //   780: aload 6
    //   782: astore 9
    //   784: aload 6
    //   786: invokevirtual 1095	android/graphics/Bitmap:getWidth	()I
    //   789: aload 6
    //   791: invokevirtual 1098	android/graphics/Bitmap:getHeight	()I
    //   794: isub
    //   795: iconst_2
    //   796: idiv
    //   797: istore_1
    //   798: iload_1
    //   799: ifle +200 -> 999
    //   802: aload 5
    //   804: astore 8
    //   806: aload 6
    //   808: astore 9
    //   810: new 1100	android/graphics/Rect
    //   813: dup
    //   814: iload_1
    //   815: iconst_0
    //   816: aload 6
    //   818: invokevirtual 1095	android/graphics/Bitmap:getWidth	()I
    //   821: iload_1
    //   822: isub
    //   823: aload 6
    //   825: invokevirtual 1098	android/graphics/Bitmap:getHeight	()I
    //   828: invokespecial 1102	android/graphics/Rect:<init>	(IIII)V
    //   831: astore 7
    //   833: aload 5
    //   835: astore 8
    //   837: aload 6
    //   839: astore 9
    //   841: aload 11
    //   843: aload 6
    //   845: aload 7
    //   847: aload 13
    //   849: aload 12
    //   851: invokevirtual 423	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   854: aload 5
    //   856: astore 8
    //   858: aload 6
    //   860: astore 9
    //   862: aload 6
    //   864: invokevirtual 1043	android/graphics/Bitmap:recycle	()V
    //   867: aload 5
    //   869: ifnull +8 -> 877
    //   872: aload 5
    //   874: invokevirtual 1035	java/io/InputStream:close	()V
    //   877: aload 6
    //   879: ifnull +8 -> 887
    //   882: aload 6
    //   884: invokevirtual 1043	android/graphics/Bitmap:recycle	()V
    //   887: aload 10
    //   889: areturn
    //   890: fload_2
    //   891: fconst_0
    //   892: fcmpl
    //   893: ifle +25 -> 918
    //   896: aload 5
    //   898: astore 8
    //   900: aload 6
    //   902: astore 9
    //   904: aload 11
    //   906: aload 7
    //   908: fload_2
    //   909: fload_2
    //   910: aload 12
    //   912: invokevirtual 400	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   915: goto -186 -> 729
    //   918: aload 5
    //   920: astore 8
    //   922: aload 6
    //   924: astore 9
    //   926: aload 11
    //   928: aload 7
    //   930: fconst_0
    //   931: ldc_w 424
    //   934: iconst_1
    //   935: aload 12
    //   937: invokevirtual 428	android/graphics/Canvas:drawArc	(Landroid/graphics/RectF;FFZLandroid/graphics/Paint;)V
    //   940: goto -211 -> 729
    //   943: astore 7
    //   945: aload 5
    //   947: astore 8
    //   949: aload 6
    //   951: astore 9
    //   953: new 503	java/lang/StringBuilder
    //   956: dup
    //   957: ldc_w 1104
    //   960: invokespecial 507	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   963: aload 7
    //   965: invokevirtual 1105	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   968: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   974: invokestatic 541	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   977: aload 5
    //   979: ifnull +8 -> 987
    //   982: aload 5
    //   984: invokevirtual 1035	java/io/InputStream:close	()V
    //   987: aload 6
    //   989: ifnull +8 -> 997
    //   992: aload 6
    //   994: invokevirtual 1043	android/graphics/Bitmap:recycle	()V
    //   997: aconst_null
    //   998: areturn
    //   999: aload 5
    //   1001: astore 8
    //   1003: aload 6
    //   1005: astore 9
    //   1007: new 1100	android/graphics/Rect
    //   1010: dup
    //   1011: iconst_0
    //   1012: iload_1
    //   1013: ineg
    //   1014: aload 6
    //   1016: invokevirtual 1095	android/graphics/Bitmap:getWidth	()I
    //   1019: iload_1
    //   1020: aload 6
    //   1022: invokevirtual 1098	android/graphics/Bitmap:getHeight	()I
    //   1025: iadd
    //   1026: invokespecial 1102	android/graphics/Rect:<init>	(IIII)V
    //   1029: astore 7
    //   1031: goto -198 -> 833
    //   1034: astore 6
    //   1036: aload 9
    //   1038: astore 7
    //   1040: aload 8
    //   1042: astore 5
    //   1044: aload 5
    //   1046: ifnull +8 -> 1054
    //   1049: aload 5
    //   1051: invokevirtual 1035	java/io/InputStream:close	()V
    //   1054: aload 7
    //   1056: ifnull +8 -> 1064
    //   1059: aload 7
    //   1061: invokevirtual 1043	android/graphics/Bitmap:recycle	()V
    //   1064: aload 6
    //   1066: athrow
    //   1067: ldc_w 1107
    //   1070: invokestatic 774	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   1073: aload_0
    //   1074: iconst_0
    //   1075: putfield 151	com/whatsapp/data/cs:k	Z
    //   1078: aload 5
    //   1080: ifnull +8 -> 1088
    //   1083: aload 5
    //   1085: invokevirtual 1035	java/io/InputStream:close	()V
    //   1088: aconst_null
    //   1089: areturn
    //   1090: astore 5
    //   1092: goto -732 -> 360
    //   1095: astore 5
    //   1097: goto -875 -> 222
    //   1100: astore 5
    //   1102: goto -548 -> 554
    //   1105: astore 5
    //   1107: goto -19 -> 1088
    //   1110: astore 5
    //   1112: goto -48 -> 1064
    //   1115: astore 6
    //   1117: aconst_null
    //   1118: astore 5
    //   1120: goto -76 -> 1044
    //   1123: astore 6
    //   1125: goto -81 -> 1044
    //   1128: astore 6
    //   1130: goto -86 -> 1044
    //   1133: astore 8
    //   1135: aload 6
    //   1137: astore 7
    //   1139: aload 8
    //   1141: astore 6
    //   1143: goto -99 -> 1044
    //   1146: astore 5
    //   1148: goto -151 -> 997
    //   1151: astore 7
    //   1153: aconst_null
    //   1154: astore 5
    //   1156: aconst_null
    //   1157: astore 6
    //   1159: goto -214 -> 945
    //   1162: astore 7
    //   1164: aconst_null
    //   1165: astore 6
    //   1167: goto -222 -> 945
    //   1170: astore 7
    //   1172: aconst_null
    //   1173: astore 6
    //   1175: goto -230 -> 945
    //   1178: astore 5
    //   1180: goto -868 -> 312
    //   1183: astore 7
    //   1185: aconst_null
    //   1186: astore 5
    //   1188: aconst_null
    //   1189: astore 6
    //   1191: goto -923 -> 268
    //   1194: astore 7
    //   1196: aconst_null
    //   1197: astore 6
    //   1199: goto -931 -> 268
    //   1202: astore 5
    //   1204: goto -317 -> 887
    //   1207: astore 5
    //   1209: goto -705 -> 504
    //   1212: aconst_null
    //   1213: astore 5
    //   1215: goto -1176 -> 39
    //   1218: astore 7
    //   1220: goto -952 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1223	0	this	cs
    //   0	1223	1	paramInt	int
    //   0	1223	2	paramFloat	float
    //   8	2	3	f1	float
    //   4	222	4	bool	boolean
    //   37	1047	5	localObject1	Object
    //   1090	1	5	localIOException1	IOException
    //   1095	1	5	localIOException2	IOException
    //   1100	1	5	localIOException3	IOException
    //   1105	1	5	localIOException4	IOException
    //   1110	1	5	localIOException5	IOException
    //   1118	1	5	localObject2	Object
    //   1146	1	5	localIOException6	IOException
    //   1154	1	5	localObject3	Object
    //   1178	1	5	localIOException7	IOException
    //   1186	1	5	localObject4	Object
    //   1202	1	5	localIOException8	IOException
    //   1207	1	5	localIOException9	IOException
    //   1213	1	5	localObject5	Object
    //   172	136	6	localInputStream	InputStream
    //   314	32	6	localIOException10	IOException
    //   427	73	6	localObject6	Object
    //   506	515	6	localIOException11	IOException
    //   1034	31	6	localObject7	Object
    //   1115	1	6	localObject8	Object
    //   1123	1	6	localObject9	Object
    //   1128	8	6	localObject10	Object
    //   1141	57	6	localObject11	Object
    //   1	1	7	localObject12	Object
    //   263	16	7	localSQLiteException1	android.database.sqlite.SQLiteException
    //   631	298	7	localObject13	Object
    //   943	21	7	localOutOfMemoryError1	OutOfMemoryError
    //   1029	109	7	localObject14	Object
    //   1151	1	7	localOutOfMemoryError2	OutOfMemoryError
    //   1162	1	7	localOutOfMemoryError3	OutOfMemoryError
    //   1170	1	7	localOutOfMemoryError4	OutOfMemoryError
    //   1183	1	7	localSQLiteException2	android.database.sqlite.SQLiteException
    //   1194	1	7	localSQLiteException3	android.database.sqlite.SQLiteException
    //   1218	1	7	localSQLiteException4	android.database.sqlite.SQLiteException
    //   144	897	8	localObject15	Object
    //   1133	7	8	localObject16	Object
    //   453	584	9	localObject17	Object
    //   572	316	10	localBitmap	Bitmap
    //   591	336	11	localCanvas	Canvas
    //   608	328	12	localPaint	Paint
    //   774	74	13	localRectF	RectF
    // Exception table:
    //   from	to	target	type
    //   39	63	263	android/database/sqlite/SQLiteException
    //   63	97	263	android/database/sqlite/SQLiteException
    //   102	116	263	android/database/sqlite/SQLiteException
    //   116	132	263	android/database/sqlite/SQLiteException
    //   137	161	263	android/database/sqlite/SQLiteException
    //   161	166	263	android/database/sqlite/SQLiteException
    //   166	174	263	android/database/sqlite/SQLiteException
    //   230	244	263	android/database/sqlite/SQLiteException
    //   244	260	263	android/database/sqlite/SQLiteException
    //   316	350	263	android/database/sqlite/SQLiteException
    //   1067	1078	263	android/database/sqlite/SQLiteException
    //   161	166	314	java/io/IOException
    //   422	442	506	java/io/IOException
    //   455	484	943	java/lang/OutOfMemoryError
    //   564	574	943	java/lang/OutOfMemoryError
    //   582	593	943	java/lang/OutOfMemoryError
    //   601	610	943	java/lang/OutOfMemoryError
    //   618	633	943	java/lang/OutOfMemoryError
    //   641	647	943	java/lang/OutOfMemoryError
    //   655	661	943	java/lang/OutOfMemoryError
    //   669	675	943	java/lang/OutOfMemoryError
    //   683	692	943	java/lang/OutOfMemoryError
    //   700	706	943	java/lang/OutOfMemoryError
    //   720	729	943	java/lang/OutOfMemoryError
    //   737	753	943	java/lang/OutOfMemoryError
    //   761	776	943	java/lang/OutOfMemoryError
    //   784	798	943	java/lang/OutOfMemoryError
    //   810	833	943	java/lang/OutOfMemoryError
    //   841	854	943	java/lang/OutOfMemoryError
    //   862	867	943	java/lang/OutOfMemoryError
    //   904	915	943	java/lang/OutOfMemoryError
    //   926	940	943	java/lang/OutOfMemoryError
    //   1007	1031	943	java/lang/OutOfMemoryError
    //   455	484	1034	finally
    //   564	574	1034	finally
    //   582	593	1034	finally
    //   601	610	1034	finally
    //   618	633	1034	finally
    //   641	647	1034	finally
    //   655	661	1034	finally
    //   669	675	1034	finally
    //   683	692	1034	finally
    //   700	706	1034	finally
    //   720	729	1034	finally
    //   737	753	1034	finally
    //   761	776	1034	finally
    //   784	798	1034	finally
    //   810	833	1034	finally
    //   841	854	1034	finally
    //   862	867	1034	finally
    //   904	915	1034	finally
    //   926	940	1034	finally
    //   953	977	1034	finally
    //   1007	1031	1034	finally
    //   355	360	1090	java/io/IOException
    //   217	222	1095	java/io/IOException
    //   549	554	1100	java/io/IOException
    //   1083	1088	1105	java/io/IOException
    //   1049	1054	1110	java/io/IOException
    //   1059	1064	1110	java/io/IOException
    //   9	24	1115	finally
    //   24	39	1115	finally
    //   39	63	1123	finally
    //   63	97	1123	finally
    //   102	116	1123	finally
    //   116	132	1123	finally
    //   137	161	1123	finally
    //   161	166	1123	finally
    //   166	174	1123	finally
    //   230	244	1123	finally
    //   244	260	1123	finally
    //   316	350	1123	finally
    //   1067	1078	1123	finally
    //   183	212	1128	finally
    //   362	422	1128	finally
    //   422	442	1128	finally
    //   508	544	1128	finally
    //   268	292	1133	finally
    //   982	987	1146	java/io/IOException
    //   992	997	1146	java/io/IOException
    //   9	24	1151	java/lang/OutOfMemoryError
    //   24	39	1151	java/lang/OutOfMemoryError
    //   39	63	1162	java/lang/OutOfMemoryError
    //   63	97	1162	java/lang/OutOfMemoryError
    //   102	116	1162	java/lang/OutOfMemoryError
    //   116	132	1162	java/lang/OutOfMemoryError
    //   137	161	1162	java/lang/OutOfMemoryError
    //   161	166	1162	java/lang/OutOfMemoryError
    //   166	174	1162	java/lang/OutOfMemoryError
    //   230	244	1162	java/lang/OutOfMemoryError
    //   244	260	1162	java/lang/OutOfMemoryError
    //   316	350	1162	java/lang/OutOfMemoryError
    //   1067	1078	1162	java/lang/OutOfMemoryError
    //   183	212	1170	java/lang/OutOfMemoryError
    //   362	422	1170	java/lang/OutOfMemoryError
    //   422	442	1170	java/lang/OutOfMemoryError
    //   508	544	1170	java/lang/OutOfMemoryError
    //   297	302	1178	java/io/IOException
    //   307	312	1178	java/io/IOException
    //   9	24	1183	android/database/sqlite/SQLiteException
    //   24	39	1183	android/database/sqlite/SQLiteException
    //   183	212	1194	android/database/sqlite/SQLiteException
    //   362	422	1194	android/database/sqlite/SQLiteException
    //   422	442	1194	android/database/sqlite/SQLiteException
    //   508	544	1194	android/database/sqlite/SQLiteException
    //   872	877	1202	java/io/IOException
    //   882	887	1202	java/io/IOException
    //   489	494	1207	java/io/IOException
    //   499	504	1207	java/io/IOException
    //   455	484	1218	android/database/sqlite/SQLiteException
    //   564	574	1218	android/database/sqlite/SQLiteException
    //   582	593	1218	android/database/sqlite/SQLiteException
    //   601	610	1218	android/database/sqlite/SQLiteException
    //   618	633	1218	android/database/sqlite/SQLiteException
    //   641	647	1218	android/database/sqlite/SQLiteException
    //   655	661	1218	android/database/sqlite/SQLiteException
    //   669	675	1218	android/database/sqlite/SQLiteException
    //   683	692	1218	android/database/sqlite/SQLiteException
    //   700	706	1218	android/database/sqlite/SQLiteException
    //   720	729	1218	android/database/sqlite/SQLiteException
    //   737	753	1218	android/database/sqlite/SQLiteException
    //   761	776	1218	android/database/sqlite/SQLiteException
    //   784	798	1218	android/database/sqlite/SQLiteException
    //   810	833	1218	android/database/sqlite/SQLiteException
    //   841	854	1218	android/database/sqlite/SQLiteException
    //   862	867	1218	android/database/sqlite/SQLiteException
    //   904	915	1218	android/database/sqlite/SQLiteException
    //   926	940	1218	android/database/sqlite/SQLiteException
    //   1007	1031	1218	android/database/sqlite/SQLiteException
  }
  
  public final Bitmap c(int paramInt1, int paramInt2)
  {
    paramInt2 = Math.min(paramInt1, paramInt2);
    if (Build.VERSION.SDK_INT >= 21) {}
    Bitmap localBitmap;
    for (paramInt1 = -1;; paramInt1 = 0)
    {
      localBitmap = b(paramInt2, paramInt1);
      if ((localBitmap != null) || (!this.k) || (paramInt2 <= 0)) {
        break;
      }
      return a(paramInt2, paramInt1, true);
    }
    return localBitmap;
  }
  
  public File c()
  {
    if (this.a.a(this.t)) {
      return this.a.c().c();
    }
    return c(this.t);
  }
  
  public final String c(Context paramContext)
  {
    if ("status@broadcast".equals(this.t)) {
      paramContext = paramContext.getString(2131297237);
    }
    String str;
    do
    {
      return paramContext;
      if ("broadcast".equals(this.t)) {
        return paramContext.getString(2131296362);
      }
      if (f()) {
        return this.A;
      }
      if (!TextUtils.isEmpty(this.e)) {
        return this.e;
      }
      if (d()) {
        return paramContext.getString(2131297018);
      }
      if (j.b(this.t))
      {
        int i1 = this.N.a(this.t).c();
        return String.format(u.a.a(2131230720, i1), new Object[] { Integer.valueOf(i1) });
      }
      str = this.H.n(this.t);
      paramContext = str;
    } while (!TextUtils.isEmpty(str));
    if (!TextUtils.isEmpty(this.q)) {
      return "~" + this.q;
    }
    return "‪" + b(this.t) + "‬";
  }
  
  public boolean d()
  {
    if (this.t == null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("row_id=").append(this.c);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(" jid=");
      String str;
      if (this.t == null)
      {
        str = "(null)";
        localStringBuilder2.append(str);
        localStringBuilder1.append(" key=");
        if (this.d != null) {
          break label152;
        }
        localStringBuilder1.append("(null)");
      }
      for (;;)
      {
        localStringBuilder1.append(" phone=").append(this.f);
        localStringBuilder1.append(" iswa=").append(this.h);
        if (this.c != -1L) {
          Log.e("problematic contact:" + localStringBuilder1.toString());
        }
        return false;
        str = this.t;
        break;
        label152:
        localStringBuilder1.append(this.d.a).append("-").append(this.d.b);
      }
    }
    return qz.e(this.t);
  }
  
  public int e()
  {
    if (j.c(this.t)) {
      return 2130837632;
    }
    if (e(this.t)) {
      return 2130837623;
    }
    if (qz.e(this.t)) {
      return 2130837628;
    }
    return 2130837625;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != getClass())) {
        return false;
      }
      paramObject = (cs)paramObject;
      if (!TextUtils.equals(this.t, ((cs)paramObject).t)) {
        return false;
      }
      if (this.d != null) {
        break;
      }
    } while (((cs)paramObject).d == null);
    return false;
    return this.d.equals(((cs)paramObject).d);
  }
  
  public boolean f()
  {
    return (i()) && (this.d == null);
  }
  
  public final long g()
  {
    if (this.d == null) {
      return 0L;
    }
    return this.d.a;
  }
  
  public final boolean h()
  {
    return (!e(this.t)) && (TextUtils.isEmpty(this.e)) && (this.A == null);
  }
  
  public int hashCode()
  {
    if (this.d != null) {
      return this.d.hashCode();
    }
    return this.t.hashCode();
  }
  
  public final boolean i()
  {
    return !TextUtils.isEmpty(this.A);
  }
  
  public final String j()
  {
    return this.A;
  }
  
  public final String k()
  {
    if ((this.d != null) && (this.o != null) && (this.o.length() != 0)) {
      return this.o;
    }
    return a(u.a());
  }
  
  public final void l()
  {
    File localFile = b();
    if (localFile.exists()) {
      localFile.delete();
    }
    for (;;)
    {
      localFile = c();
      if (!localFile.exists()) {
        break;
      }
      localFile.delete();
      return;
      Log.i("WAContact/delete_photo_files " + localFile.getAbsolutePath() + " does not exist, nothing to delete.");
    }
    Log.i("WAContact/delete_photo_files " + localFile.getAbsolutePath() + " does not exist, nothing to delete.");
  }
  
  public final void m()
  {
    String str1 = s();
    android.support.v4.f.f localf = this.I.a.b;
    Iterator localIterator = localf.d().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (str2.startsWith(str1)) {
        localf.b(str2);
      }
    }
    this.k = true;
  }
  
  public final boolean n()
  {
    return b(u.a().getResources().getDimensionPixelSize(2131362090), u.a().getResources().getDimension(2131361833)) != null;
  }
  
  public final Uri o()
  {
    return ContentUris.withAppendedId(ContactProvider.a, this.c);
  }
  
  final Map<Class<? extends AppBarLayout.b>, AppBarLayout.b> p()
  {
    if (this.z == null) {
      return Collections.emptyMap();
    }
    return this.z;
  }
  
  public final String q()
  {
    if (qz.e(this.t)) {
      return this.t.substring(0, this.t.indexOf("-")) + "@s.whatsapp.net";
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("row_id=").append(this.c);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(" jid=");
    String str;
    if (this.t == null)
    {
      str = "(null)";
      localStringBuilder2.append(str);
      localStringBuilder1.append(" key=");
      if (this.d != null) {
        break label154;
      }
      localStringBuilder1.append("(null)");
      label71:
      localStringBuilder1.append(" phone=").append(this.f);
      localStringBuilder1.append(" iswa=").append(this.h);
      if (!d()) {
        break label185;
      }
      localStringBuilder1.append(" name=").append(a(u.a()));
      localStringBuilder1.append(" status=").append(this.u);
    }
    for (;;)
    {
      return localStringBuilder1.toString();
      str = this.t;
      break;
      label154:
      localStringBuilder1.append(this.d.a).append("-").append(this.d.b);
      break label71;
      label185:
      if (av.k())
      {
        localStringBuilder1.append(" name=").append(this.e);
        if (this.A != null) {
          localStringBuilder1.append(" verified_name=").append(this.A);
        }
        if (this.w != null) {
          localStringBuilder1.append(" nickname=").append(this.w);
        }
        if (this.x != null) {
          localStringBuilder1.append(" company=").append(this.x);
        }
        if (this.y != null) {
          localStringBuilder1.append(" title=").append(this.y);
        }
      }
    }
  }
  
  public static final class a
  {
    public final long a;
    public final String b;
    
    public a(long paramLong, String paramString)
    {
      this.a = paramLong;
      this.b = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (paramObject.getClass() != getClass())) {
          return false;
        }
        paramObject = (a)paramObject;
      } while ((this.a == ((a)paramObject).a) && (TextUtils.equals(this.b, ((a)paramObject).b)));
      return false;
    }
    
    public final int hashCode()
    {
      int j = (int)(this.a ^ this.a >>> 32);
      if (this.b != null) {}
      for (int i = this.b.hashCode();; i = 0) {
        return i + j * 31;
      }
    }
    
    public final String toString()
    {
      return this.a + ":" + this.b;
    }
  }
  
  public static final class b
    extends cs.f
  {
    public b(cs paramcs)
    {
      super();
    }
    
    protected final boolean a(cs paramcs)
    {
      if ((!TextUtils.equals(this.a.e, paramcs.e)) || (!TextUtils.equals(this.a.A, paramcs.A))) {}
      for (boolean bool = true;; bool = false)
      {
        paramcs.e = this.a.e;
        paramcs.D = this.a.D;
        paramcs.A = this.a.A;
        paramcs.B = this.a.B;
        return bool;
      }
    }
  }
  
  public static final class c
    extends cs.f
  {
    public c(cs paramcs)
    {
      super();
    }
    
    protected final boolean a(cs paramcs)
    {
      paramcs.k = this.a.k;
      if (((this.a.l > 0) && (paramcs.l != this.a.l)) || ((this.a.m > 0) && (paramcs.m != this.a.m)) || ((this.a.l < 0) && (paramcs.l >= 0)) || ((this.a.m < 0) && (paramcs.m >= 0))) {}
      for (boolean bool = true;; bool = false)
      {
        paramcs.l = this.a.l;
        paramcs.m = this.a.m;
        paramcs.n = this.a.n;
        return bool;
      }
    }
  }
  
  public static final class d
    extends cs.f
  {
    public d(cs paramcs)
    {
      super();
    }
    
    protected final boolean a(cs paramcs)
    {
      if (!TextUtils.equals(this.a.u, paramcs.u)) {}
      for (boolean bool = true;; bool = false)
      {
        paramcs.u = this.a.u;
        paramcs.v = this.a.v;
        return bool;
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract boolean b(cs paramcs);
  }
  
  static abstract class f
    implements cs.e
  {
    protected final cs a;
    
    public f(cs paramcs)
    {
      this.a = paramcs;
    }
    
    protected abstract boolean a(cs paramcs);
    
    public final boolean b(cs paramcs)
    {
      if (paramcs == this.a) {}
      do
      {
        return true;
        if (this.a.t == null)
        {
          Log.e("wacontact/updatecontact/invalid");
          return false;
        }
      } while ((this.a.t.equals(paramcs.t)) && (a(paramcs)));
      return false;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */