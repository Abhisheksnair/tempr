package com.whatsapp;

import android.net.Uri;
import android.text.TextUtils;
import com.whatsapp.data.ad;
import com.whatsapp.data.cq;
import com.whatsapp.data.y;
import com.whatsapp.l.e;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.m;
import com.whatsapp.util.MediaFileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vp
{
  private static volatile vp k;
  final pv a;
  final va b;
  final oz c;
  final aic d;
  final ad e;
  final e f;
  final y g;
  final vv h;
  final atv i;
  final rh j;
  private final ant l;
  private final vs m;
  private final cq n;
  
  private vp(ant paramant, pv parampv, va paramva, oz paramoz, aic paramaic, ad paramad, e parame, y paramy, vv paramvv, atv paramatv, vs paramvs, cq paramcq, rh paramrh)
  {
    this.l = paramant;
    this.a = parampv;
    this.b = paramva;
    this.c = paramoz;
    this.d = paramaic;
    this.e = paramad;
    this.f = parame;
    this.g = paramy;
    this.h = paramvv;
    this.i = paramatv;
    this.m = paramvs;
    this.n = paramcq;
    this.j = paramrh;
  }
  
  public static vp a()
  {
    if (k == null) {}
    try
    {
      if (k == null) {
        k = new vp(ant.a(), pv.a(), va.a(), oz.a(), aic.a(), ad.a(), e.a(), y.a(), vv.a(), atv.a(), vs.a(), cq.a(), rh.a());
      }
      return k;
    }
    finally {}
  }
  
  public final aoi a(List<String> paramList1, MediaData paramMediaData, byte paramByte, int paramInt, String paramString, Uri paramUri, j paramj, List<String> paramList2, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList1.size() > 1) {}
    for (String str = b();; str = null)
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext()) {
        localArrayList.add(a((String)paramList1.next(), paramMediaData.createSerializableCopy(), paramByte, paramInt, paramString, paramUri, paramj, str, paramList2, paramBoolean));
      }
    }
    return new aoi(localArrayList);
  }
  
  public final aoi a(List<String> paramList, MediaData paramMediaData, String paramString, j paramj, boolean paramBoolean)
  {
    return a(paramList, paramMediaData, (byte)9, 0, paramString, null, paramj, null, paramBoolean);
  }
  
  public final aqy a(aoj paramaoj, j paramj)
  {
    return new aqy(this.a, this.b, this.c, this.d, paramaoj, this.e, this.f, this.g, this.h, this.i, this.j, this.m, paramj);
  }
  
  public final j a(String paramString1, MediaData paramMediaData, byte paramByte, int paramInt, String paramString2, Uri paramUri, j paramj, String paramString3, List<String> paramList, boolean paramBoolean)
  {
    paramString1 = new j(this.b, paramString1, paramMediaData);
    paramString1.n = this.l.b();
    paramString1.s = paramByte;
    paramString1.o = paramInt;
    paramString1.a(paramj, this.n);
    if (paramString2 != null)
    {
      paramString1.z = paramString2.trim();
      if (TextUtils.isEmpty(paramString1.z)) {
        paramString1.z = null;
      }
    }
    if (paramMediaData.file == null)
    {
      paramString1.y = paramUri.toString();
      paramString1.t = 0L;
      if ((paramByte == 2) || (paramByte == 3) || (paramByte == 13))
      {
        if ((paramMediaData.trimFrom <= 0L) && (paramMediaData.trimTo <= 0L)) {
          break label248;
        }
        paramString1.w = ((int)((paramMediaData.trimTo - paramMediaData.trimFrom) / 1000L));
      }
      label148:
      if ((paramList != null) && (!paramList.isEmpty())) {
        paramString1.P = paramList;
      }
      paramString1.d = 1;
      paramMediaData.fileSize = paramString1.t;
      paramMediaData.autodownloadRetryEnabled = true;
      paramString1.W = paramString3;
      if (!paramBoolean) {
        break label262;
      }
      paramInt = 4;
      label201:
      if (TextUtils.isEmpty(paramString3)) {
        break label268;
      }
    }
    label248:
    label262:
    label268:
    for (int i1 = 1;; i1 = 0)
    {
      paramString1.X = (paramInt | i1);
      return paramString1;
      paramString1.y = paramMediaData.file.getName();
      paramString1.t = paramMediaData.file.length();
      break;
      paramString1.w = MediaFileUtils.b(paramMediaData.file);
      break label148;
      paramInt = 0;
      break label201;
    }
  }
  
  public final j a(String paramString, MediaData paramMediaData, j paramj, boolean paramBoolean)
  {
    return a(paramString, paramMediaData, (byte)2, 1, null, null, paramj, null, null, paramBoolean);
  }
  
  public final xg a(aoi paramaoi, boolean paramBoolean)
  {
    return new xg(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.m, paramaoi, false, paramBoolean);
  }
  
  final String b()
  {
    byte[] arrayOfByte = m.a(this.b);
    if (arrayOfByte == null) {
      throw new IllegalStateException("multicast id could not be created");
    }
    return m.b(arrayOfByte);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/vp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */