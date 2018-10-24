package com.whatsapp.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.support.v7.app.b.a;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Display;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.whatsapp.aus;
import com.whatsapp.av;
import com.whatsapp.ox;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class bm
{
  public static boolean a;
  public static File b = null;
  private static FileWriter c = null;
  private static String d = null;
  private static String e = "android-";
  private static String f = null;
  private static int g = -1;
  private static JSONObject h = null;
  private static JSONArray i = null;
  private static Set<View> j;
  private static Map<Long, Integer> k;
  private static Map<Bitmap, Integer> l;
  private static Map<String, Integer> m;
  private static boolean n;
  private static String o;
  
  static
  {
    a = false;
    j = new HashSet();
    k = null;
    l = null;
    m = new HashMap();
    n = false;
    o = "";
  }
  
  public static b.a a(ox paramox, aus paramaus, Activity paramActivity)
  {
    b.a locala = new b.a(paramActivity);
    locala.a("New Series");
    locala.b("(e.g. CHATS)");
    View localView = paramActivity.getLayoutInflater().inflate(2130903387, null);
    locala.a(localView);
    locala.a("Begin Series", bn.a((EditText)localView.findViewById(2131756141), (CheckBox)localView.findViewById(2131756142), (CheckBox)localView.findViewById(2131756143), paramox, paramaus, paramActivity));
    return locala;
  }
  
  public static void a()
  {
    try
    {
      if (c != null)
      {
        h.put("platform", "Android");
        h.put("locale", o);
        h.put("strings", i);
        c.write(h.toString() + "\n");
        c.flush();
        c.close();
      }
      m.put(d, Integer.valueOf(g));
      i1 = g + 1;
      while (i1 < 10)
      {
        Object localObject = "0" + i1;
        localObject = new File(b, e + f + "-" + d + "-" + (String)localObject + ".png");
        if (!((File)localObject).exists()) {
          break label274;
        }
        ((File)localObject).delete();
        i1 += 1;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("truncationUtils/finalize exception closing truncations file " + localIOException.toString());
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        int i1;
        Log.e("truncationUtils/finalize JSON exception " + localJSONException.toString());
        continue;
        String str = String.valueOf(i1);
      }
      label274:
      c = null;
      d = null;
      g = 0;
      h = null;
      i = null;
      k = null;
      l = null;
      b = null;
      Log.i("truncationUtils/finalize complete");
    }
  }
  
  public static void a(Activity paramActivity)
  {
    a((ViewGroup)paramActivity.findViewById(16908290).getRootView(), paramActivity, false);
  }
  
  private static void a(View paramView, long paramLong, boolean paramBoolean, Activity paramActivity)
  {
    Object localObject1 = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay();
    int i3 = ((Display)localObject1).getHeight();
    int i4 = ((Display)localObject1).getWidth();
    Object localObject2 = paramView.getRootView();
    if (localObject2 == null)
    {
      Log.d("truncationUtils/takeScreenshot root null");
      return;
    }
    ((View)localObject2).setDrawingCacheEnabled(true);
    localObject1 = ((View)localObject2).getDrawingCache();
    if (localObject1 == null)
    {
      Log.d("truncationUtils/takeScreenshot root_bm null");
      return;
    }
    int i1 = ((Bitmap)localObject1).getHeight();
    if ((paramBoolean) && (i1 >= i3 - 25))
    {
      Log.i("truncationUtils/takeScreenshot height too large -> likely not a menu; bm_height = " + i1);
      return;
    }
    if (k == null) {
      k = new HashMap();
    }
    if (l == null) {
      l = new HashMap();
    }
    if (d == null)
    {
      Log.i("truncationUtils/takeScreenshot series is null");
      return;
    }
    int i2;
    if (k.containsKey(Long.valueOf(paramLong)))
    {
      i1 = ((Integer)k.get(Long.valueOf(paramLong))).intValue();
      Log.i("truncationUtils/takeScreenshot sid = rootToSID.get(key); sid is " + i1);
      i2 = 0;
      if (!paramBoolean) {
        break label557;
      }
    }
    for (;;)
    {
      try
      {
        Log.i("truncationUtils/takeScreenshot attempt screenshot of menu");
      }
      catch (FileNotFoundException paramView)
      {
        Object localObject3;
        try
        {
          paramView = Bitmap.createBitmap(i4, i3, Bitmap.Config.RGB_565);
          localObject3 = new Canvas(paramView);
          paramActivity.findViewById(16908290).getRootView().draw((Canvas)localObject3);
          paramActivity = new int[2];
          ((View)localObject2).getLocationOnScreen(paramActivity);
          ((Canvas)localObject3).drawBitmap((Bitmap)localObject1, paramActivity[0], paramActivity[1], null);
          paramActivity = new HashSet();
          localObject2 = l.keySet().iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label857;
          }
          localObject3 = (Bitmap)((Iterator)localObject2).next();
          i3 = ((Integer)l.get(localObject3)).intValue();
          if ((!paramBoolean) || ((!((Bitmap)localObject3).sameAs(paramView)) && (!((Bitmap)localObject3).sameAs((Bitmap)localObject1)))) {
            continue;
          }
          Log.i("truncationUtils/takeScreenshot bitmap same; to_write: " + ((Bitmap)localObject3).sameAs(paramView) + " root: " + ((Bitmap)localObject3).sameAs((Bitmap)localObject1));
          i1 = 1;
          paramActivity = paramActivity.iterator();
          if (!paramActivity.hasNext()) {
            break label617;
          }
          localObject2 = (Bitmap)paramActivity.next();
          l.remove(localObject2);
          continue;
          paramView = paramView;
          Log.e("truncationUtils/takeScreenshot exception creating file " + paramView.toString());
          return;
          i1 = g + 1;
          g = i1;
          Log.i("truncationUtils/takeScreenshot incrementedSIDis true; sid is " + i1);
          i2 = 1;
        }
        catch (OutOfMemoryError paramView)
        {
          System.gc();
          paramView = Bitmap.createBitmap(i4, i3, Bitmap.Config.ARGB_4444);
          continue;
        }
        Log.i("truncationUtils/takeScreenshot attempt screenshot of full activity");
        paramView = (View)localObject1;
        continue;
        if (g - i3 <= 3) {
          continue;
        }
        paramActivity.add(localObject3);
        continue;
      }
      catch (IOException paramView)
      {
        label557:
        Log.e("truncationUtils/takeScreenshot io exception" + paramView.toString());
        return;
      }
      label617:
      if ((i1 != 0) && (i2 != 0))
      {
        g -= 1;
        Log.i("truncationUtils/takeScreenshot --truncationsScreenshotID;" + g);
      }
      if (i3 < 10) {}
      for (paramActivity = "0" + i3;; paramActivity = String.valueOf(i3))
      {
        paramActivity = new FileOutputStream(new File(b, e + f + "-" + d + "-" + paramActivity + ".png"));
        paramView.compress(Bitmap.CompressFormat.PNG, 100, paramActivity);
        k.put(Long.valueOf(paramLong), Integer.valueOf(i3));
        l.put(localObject1, Integer.valueOf(i3));
        l.put(paramView, Integer.valueOf(i3));
        paramActivity.flush();
        paramActivity.close();
        Log.i("truncationUtils/takeScreenshot screenshot success with sid " + i3);
        return;
      }
      label857:
      i4 = 0;
      i3 = i1;
      i1 = i4;
    }
  }
  
  private static void a(View paramView, List<TextView> paramList)
  {
    if ((paramView instanceof ViewGroup))
    {
      int i2 = ((ViewGroup)paramView).getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        a(((ViewGroup)paramView).getChildAt(i1), paramList);
        i1 += 1;
      }
    }
    if ((paramView instanceof TextView)) {
      paramList.add((TextView)paramView);
    }
  }
  
  public static void a(ViewGroup paramViewGroup, Activity paramActivity, boolean paramBoolean)
  {
    if (d == null) {
      return;
    }
    Log.i("truncationUtils/findTruncations");
    long l1 = paramViewGroup.getHeight() * paramViewGroup.getWidth() + (paramViewGroup.hashCode() + paramViewGroup.getDrawingTime());
    Log.i("truncationUtils/findTruncations key: " + l1);
    a(paramViewGroup, l1, paramBoolean, paramActivity);
    if ((k == null) || (!k.containsKey(Long.valueOf(l1))))
    {
      Log.i("truncationUtils/findTruncations skipped");
      return;
    }
    int i1 = ((Integer)k.get(Long.valueOf(l1))).intValue();
    Log.i("truncationUtils/findTruncations sid: " + i1);
    paramActivity = new ArrayList();
    a(paramViewGroup, paramActivity);
    Iterator localIterator = paramActivity.iterator();
    label157:
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (TextView)localIterator.next();
      paramViewGroup = ((TextView)localObject).getLayout();
      TextPaint localTextPaint = ((TextView)localObject).getPaint();
      paramActivity = ((TextView)localObject).getText();
      if (n) {
        ((TextView)localObject).setTextColor(-16711936);
      }
      int i2 = ((TextView)localObject).getLineCount();
      if (i2 <= 0) {
        break label459;
      }
      paramViewGroup = paramActivity.subSequence(paramViewGroup.getLineStart(i2 - 1), paramViewGroup.getLineEnd(i2 - 1));
      label247:
      float f1 = localTextPaint.measureText(paramViewGroup, 0, paramViewGroup.length());
      float f2 = ((TextView)localObject).getWidth() - ((TextView)localObject).getCompoundPaddingLeft() - ((TextView)localObject).getCompoundPaddingRight();
      paramActivity = paramActivity.toString();
      Log.i("truncationUtils/findTruncations text: " + paramActivity);
      if ((f2 > 0.0F) && (b((View)localObject)) && (!TextUtils.isEmpty(paramActivity)) && (c != null))
      {
        localObject = new JSONArray();
        if (i1 >= 10) {
          break label464;
        }
        paramViewGroup = "0" + i1;
        label371:
        ((JSONArray)localObject).put(d + "-" + paramViewGroup);
        ((JSONArray)localObject).put(paramActivity);
        ((JSONArray)localObject).put(Double.valueOf(f2));
        ((JSONArray)localObject).put(Double.valueOf(f1));
        if (f1 <= f2) {
          break label473;
        }
        ((JSONArray)localObject).put(true);
      }
    }
    for (;;)
    {
      i.put(localObject);
      break label157;
      break;
      label459:
      paramViewGroup = paramActivity;
      break label247;
      label464:
      paramViewGroup = String.valueOf(i1);
      break label371;
      label473:
      ((JSONArray)localObject).put(false);
    }
  }
  
  public static void b(Activity paramActivity)
  {
    if (!av.j()) {
      throw new UnsupportedOperationException();
    }
    Log.i("truncationUtils/findMenuTruncations");
    if (d == null) {
      return;
    }
    LayoutInflater localLayoutInflater = paramActivity.getLayoutInflater();
    if (localLayoutInflater.getFactory() != null)
    {
      Log.i("truncationUtils/findMenuTruncations factory already exists");
      return;
    }
    localLayoutInflater.setFactory(bo.a(paramActivity));
  }
  
  private static boolean b(View paramView)
  {
    View localView = paramView.getRootView();
    for (;;)
    {
      if (paramView == localView) {
        return true;
      }
      if (paramView.getVisibility() != 0) {
        return false;
      }
      paramView = paramView.getParent();
      if (paramView == null) {
        return false;
      }
      if (!(paramView instanceof View)) {
        return true;
      }
      paramView = (View)paramView;
      if (paramView == null) {
        return false;
      }
    }
  }
  
  public static void c(Activity paramActivity)
  {
    Log.d("truncationUtils/installMenuInspector called");
    if (LayoutInflater.from(paramActivity).getFactory() != null)
    {
      Log.i("truncationUtils/installMenuInspector factory already exists");
      return;
    }
    LayoutInflater.from(paramActivity).cloneInContext(paramActivity).setFactory(bp.a(paramActivity));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */