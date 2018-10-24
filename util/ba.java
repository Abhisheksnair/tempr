package com.whatsapp.util;

import a.a.a.a.a.a.a;
import a.a.a.a.a.a.b;
import a.a.a.a.a.a.c;
import a.a.a.a.a.a.d;
import a.a.a.a.a.a.e;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredPostal;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.telephony.PhoneNumberUtils;
import com.whatsapp.Conversation;
import com.whatsapp.and;
import com.whatsapp.atu;
import com.whatsapp.contact.sync.i;
import com.whatsapp.contact.sync.t.a;
import com.whatsapp.contact.sync.w;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.data.cs.a;
import com.whatsapp.data.e;
import com.whatsapp.dh;
import com.whatsapp.nh;
import com.whatsapp.pv;
import com.whatsapp.rh;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ba
{
  private static volatile ba d;
  final e a;
  final dh b;
  final rh c;
  private final pv e;
  private final ad f;
  private final and g;
  private final i h;
  private final atu i;
  
  private ba(pv parampv, ad paramad, e parame, and paramand, dh paramdh, i parami, atu paramatu, rh paramrh)
  {
    this.e = parampv;
    this.f = paramad;
    this.a = parame;
    this.g = paramand;
    this.b = paramdh;
    this.h = parami;
    this.i = paramatu;
    this.c = paramrh;
  }
  
  @TargetApi(11)
  private static Intent a(String paramString1, String paramString2, String paramString3, ArrayList<ContentValues> paramArrayList)
  {
    paramString1 = new Intent(paramString1, ContactsContract.Contacts.CONTENT_URI);
    paramString1.setType(paramString2);
    paramString1.putExtra("finishActivityOnSaveCompleted", true);
    paramString1.putExtra("name", paramString3);
    int j;
    if (!paramArrayList.isEmpty())
    {
      paramString2 = (ContentValues)paramArrayList.get(0);
      paramString3 = paramString2.getAsString("mimetype");
      j = -1;
      switch (paramString3.hashCode())
      {
      default: 
        switch (j)
        {
        default: 
          j = 1;
        }
        break;
      }
    }
    for (;;)
    {
      if (j != 0) {
        paramArrayList.remove(0);
      }
      paramString1.putParcelableArrayListExtra("data", paramArrayList);
      return paramString1;
      if (!paramString3.equals("vnd.android.cursor.item/phone_v2")) {
        break;
      }
      j = 0;
      break;
      if (!paramString3.equals("vnd.android.cursor.item/email_v2")) {
        break;
      }
      j = 1;
      break;
      if (!paramString3.equals("vnd.android.cursor.item/postal-address_v2")) {
        break;
      }
      j = 2;
      break;
      if (!paramString3.equals("vnd.android.cursor.item/organization")) {
        break;
      }
      j = 3;
      break;
      if (!paramString3.equals("vnd.android.cursor.item/nickname")) {
        break;
      }
      j = 4;
      break;
      if (!paramString3.equals("vnd.android.cursor.item/contact_event")) {
        break;
      }
      j = 5;
      break;
      if (!paramString3.equals("vnd.android.cursor.item/im")) {
        break;
      }
      j = 6;
      break;
      if (!paramString3.equals("vnd.android.cursor.item/photo")) {
        break;
      }
      j = 7;
      break;
      paramString1.putExtra("phone", paramString2.getAsString("data1"));
      paramString1.putExtra("phone_type", paramString2.getAsString("data3"));
      j = 1;
      continue;
      paramString1.putExtra("email", paramString2.getAsString("data1"));
      paramString1.putExtra("email_type", paramString2.getAsString("data3"));
      j = 1;
      continue;
      paramString1.putExtra("postal", paramString2.getAsString("data4") + ", " + paramString2.getAsString("data7") + ", " + paramString2.getAsString("data8") + " " + paramString2.getAsString("data9") + ", " + paramString2.getAsString("data10"));
      paramString1.putExtra("postal_type", paramString2.getAsString("data3"));
      j = 1;
      continue;
      paramString3 = new StringBuilder();
      paramString3.append(paramString2.getAsString("data1"));
      String str = paramString2.getAsString("data5");
      if (str != null)
      {
        paramString3.append(", ");
        paramString3.append(str);
      }
      paramString1.putExtra("company", paramString3.toString());
      paramString1.putExtra("job_title", paramString2.getAsString("data4"));
      j = 1;
      continue;
      j = 0;
      continue;
      j = 0;
      continue;
      paramString1.putExtra("im_protocol", paramString2.getAsString("data5"));
      paramString1.putExtra("im_handle", paramString2.getAsString("data1"));
      j = 1;
      continue;
      j = 0;
    }
  }
  
  public static ba a()
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new ba(pv.a(), ad.a(), e.a(), and.a(), dh.a(), i.a(), atu.a(), rh.a());
      }
      return d;
    }
    finally {}
  }
  
  private static ArrayList<ContentValues> a(Resources paramResources, a.a.a.a.a.a parama, Bitmap paramBitmap)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    ContentValues localContentValues;
    if (parama.h != null)
    {
      localObject1 = parama.h.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a.e)((Iterator)localObject1).next();
        localContentValues = new ContentValues();
        localContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        localContentValues.put("data1", ((a.e)localObject2).b);
        localContentValues.put("data2", Integer.valueOf(((a.e)localObject2).a));
        localContentValues.put("data3", ContactsContract.CommonDataKinds.Phone.getTypeLabel(paramResources, ((a.e)localObject2).a, ((a.e)localObject2).c).toString());
        localArrayList.add(localContentValues);
      }
    }
    if (parama.i != null)
    {
      localObject1 = parama.i.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a.b)((Iterator)localObject1).next();
        if (((a.b)localObject2).a == ContactsContract.CommonDataKinds.Email.class)
        {
          localContentValues = new ContentValues();
          localContentValues.put("mimetype", "vnd.android.cursor.item/email_v2");
          localContentValues.put("data1", ((a.b)localObject2).c);
          localContentValues.put("data2", Integer.valueOf(((a.b)localObject2).b));
          localContentValues.put("data3", ContactsContract.CommonDataKinds.Email.getTypeLabel(paramResources, ((a.b)localObject2).b, ((a.b)localObject2).e).toString());
          localArrayList.add(localContentValues);
        }
        else if (((a.b)localObject2).a == ContactsContract.CommonDataKinds.StructuredPostal.class)
        {
          localContentValues = new ContentValues();
          localContentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
          localContentValues.put("data4", ((a.b)localObject2).d.b());
          localContentValues.put("data7", ((a.b)localObject2).d.b);
          localContentValues.put("data8", ((a.b)localObject2).d.c);
          localContentValues.put("data9", ((a.b)localObject2).d.d);
          localContentValues.put("data10", ((a.b)localObject2).d.e);
          localContentValues.put("data2", Integer.valueOf(((a.b)localObject2).b));
          localContentValues.put("data3", ContactsContract.CommonDataKinds.StructuredPostal.getTypeLabel(paramResources, ((a.b)localObject2).b, ((a.b)localObject2).e).toString());
          localArrayList.add(localContentValues);
        }
        else if (((a.b)localObject2).a == ContactsContract.CommonDataKinds.Im.class)
        {
          Log.e("sharecontactutil " + localObject2.toString());
        }
        else
        {
          Log.e("sharecontactutil/type/unknown " + localObject2.toString());
        }
      }
    }
    int j;
    if ((parama.j != null) && (parama.j.size() > 0))
    {
      localObject1 = (a.d)parama.j.get(0);
      j = ((a.d)localObject1).b.lastIndexOf(" ");
      if (j <= 0) {
        break label970;
      }
    }
    label970:
    for (paramResources = ((a.d)localObject1).b.substring(0, j);; paramResources = ((a.d)localObject1).b)
    {
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("mimetype", "vnd.android.cursor.item/organization");
      ((ContentValues)localObject2).put("data1", paramResources);
      if (j > 0) {
        ((ContentValues)localObject2).put("data5", ((a.d)localObject1).b.substring(j + 1));
      }
      ((ContentValues)localObject2).put("data4", ((a.d)localObject1).c);
      localArrayList.add(localObject2);
      if (parama.k == null) {
        break;
      }
      paramResources = parama.k.keySet().iterator();
      while (paramResources.hasNext())
      {
        localObject1 = (String)paramResources.next();
        if (((String)localObject1).equals("NICKNAME"))
        {
          localObject2 = new ContentValues();
          ((ContentValues)localObject2).put("mimetype", "vnd.android.cursor.item/nickname");
          ((ContentValues)localObject2).put("data1", ((a.a.a.a.a)((List)parama.k.get(localObject1)).get(0)).b);
          localArrayList.add(localObject2);
        }
        if (((String)localObject1).equals("BDAY"))
        {
          localObject2 = new ContentValues();
          ((ContentValues)localObject2).put("mimetype", "vnd.android.cursor.item/contact_event");
          ((ContentValues)localObject2).put("data2", Integer.valueOf(3));
          ((ContentValues)localObject2).put("data1", ((a.a.a.a.a)((List)parama.k.get(localObject1)).get(0)).b);
          localArrayList.add(localObject2);
        }
        if (a.a.a.a.a.a.a.containsKey(localObject1))
        {
          localObject2 = (a.a.a.a.a)((List)parama.k.get(localObject1)).get(0);
          localContentValues = new ContentValues();
          localContentValues.put("mimetype", "vnd.android.cursor.item/im");
          localContentValues.put("data5", (Integer)a.a.a.a.a.a.a.get(localObject1));
          localContentValues.put("data1", ((a.a.a.a.a)((List)parama.k.get(localObject1)).get(0)).b);
          if ((((a.a.a.a.a)localObject2).f != null) && (((a.a.a.a.a)localObject2).f.size() > 0)) {
            localContentValues.put("data2", (String)localObject2.f.toArray()[0]);
          }
          localArrayList.add(localContentValues);
        }
      }
    }
    if (paramBitmap != null)
    {
      paramResources = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramResources);
      parama = paramResources.toByteArray();
      paramBitmap = new ContentValues();
      paramBitmap.put("mimetype", "vnd.android.cursor.item/photo");
      paramBitmap.put("data15", parama);
      localArrayList.add(paramBitmap);
    }
    try
    {
      paramResources.close();
      return localArrayList;
    }
    catch (IOException paramResources) {}
    return localArrayList;
  }
  
  @TargetApi(11)
  public static void a(a.a.a.a.a.a parama, Bitmap paramBitmap, Activity paramActivity, int paramInt)
  {
    paramBitmap = a(paramActivity.getResources(), parama, paramBitmap);
    paramActivity.startActivityForResult(a("android.intent.action.INSERT", "vnd.android.cursor.dir/raw_contact", parama.c.a, paramBitmap), paramInt);
  }
  
  @TargetApi(11)
  public static void b(a.a.a.a.a.a parama, Bitmap paramBitmap, Activity paramActivity, int paramInt)
  {
    paramBitmap = a(paramActivity.getResources(), parama, paramBitmap);
    paramActivity.startActivityForResult(a("android.intent.action.INSERT_OR_EDIT", "vnd.android.cursor.item/contact", parama.c.a, paramBitmap), paramInt);
  }
  
  public final void a(a.a.a.a.a.a parama, Bitmap paramBitmap, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, nh paramnh)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
    ((ContentProviderOperation.Builder)localObject1).withValue("account_name", null);
    ((ContentProviderOperation.Builder)localObject1).withValue("account_type", null);
    localArrayList.add(((ContentProviderOperation.Builder)localObject1).build());
    localObject1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
    ((ContentProviderOperation.Builder)localObject1).withValueBackReference("raw_contact_id", 0);
    ((ContentProviderOperation.Builder)localObject1).withValue("mimetype", "vnd.android.cursor.item/name");
    ((ContentProviderOperation.Builder)localObject1).withValue("data1", parama.c.a);
    ((ContentProviderOperation.Builder)localObject1).withValue("data3", parama.c.c);
    ((ContentProviderOperation.Builder)localObject1).withValue("data2", parama.c.b);
    ((ContentProviderOperation.Builder)localObject1).withValue("data5", parama.c.d);
    ((ContentProviderOperation.Builder)localObject1).withValue("data4", parama.c.e);
    ((ContentProviderOperation.Builder)localObject1).withValue("data6", parama.c.f);
    ((ContentProviderOperation.Builder)localObject1).withValue("data7", parama.c.g);
    ((ContentProviderOperation.Builder)localObject1).withValue("data9", parama.c.h);
    localArrayList.add(((ContentProviderOperation.Builder)localObject1).build());
    Object localObject2;
    Object localObject3;
    if (parama.h != null)
    {
      localObject1 = parama.h.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a.e)((Iterator)localObject1).next();
        localObject3 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        ((ContentProviderOperation.Builder)localObject3).withValueBackReference("raw_contact_id", 0);
        ((ContentProviderOperation.Builder)localObject3).withValue("mimetype", "vnd.android.cursor.item/phone_v2");
        ((ContentProviderOperation.Builder)localObject3).withValue("data1", ((a.e)localObject2).b);
        ((ContentProviderOperation.Builder)localObject3).withValue("data2", Integer.valueOf(((a.e)localObject2).a));
        if (((a.e)localObject2).a == 0) {
          ((ContentProviderOperation.Builder)localObject3).withValue("data3", ((a.e)localObject2).c);
        }
        localArrayList.add(((ContentProviderOperation.Builder)localObject3).build());
      }
    }
    if (parama.i != null)
    {
      localObject1 = parama.i.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a.b)((Iterator)localObject1).next();
        if (((a.b)localObject2).a == ContactsContract.CommonDataKinds.Email.class)
        {
          localObject3 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
          ((ContentProviderOperation.Builder)localObject3).withValueBackReference("raw_contact_id", 0);
          ((ContentProviderOperation.Builder)localObject3).withValue("mimetype", "vnd.android.cursor.item/email_v2");
          ((ContentProviderOperation.Builder)localObject3).withValue("data1", ((a.b)localObject2).c);
          ((ContentProviderOperation.Builder)localObject3).withValue("data2", Integer.valueOf(((a.b)localObject2).b));
          if (((a.b)localObject2).b == 0) {
            ((ContentProviderOperation.Builder)localObject3).withValue("data3", ((a.b)localObject2).e);
          }
          localArrayList.add(((ContentProviderOperation.Builder)localObject3).build());
        }
        else if (((a.b)localObject2).a == ContactsContract.CommonDataKinds.StructuredPostal.class)
        {
          localObject3 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
          ((ContentProviderOperation.Builder)localObject3).withValueBackReference("raw_contact_id", 0);
          ((ContentProviderOperation.Builder)localObject3).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2");
          ((ContentProviderOperation.Builder)localObject3).withValue("data4", ((a.b)localObject2).d.b());
          ((ContentProviderOperation.Builder)localObject3).withValue("data7", ((a.b)localObject2).d.b);
          ((ContentProviderOperation.Builder)localObject3).withValue("data8", ((a.b)localObject2).d.c);
          ((ContentProviderOperation.Builder)localObject3).withValue("data9", ((a.b)localObject2).d.d);
          ((ContentProviderOperation.Builder)localObject3).withValue("data10", ((a.b)localObject2).d.e);
          ((ContentProviderOperation.Builder)localObject3).withValue("data2", Integer.valueOf(((a.b)localObject2).b));
          if (((a.b)localObject2).b == 0) {
            ((ContentProviderOperation.Builder)localObject3).withValue("data3", ((a.b)localObject2).e);
          }
          localArrayList.add(((ContentProviderOperation.Builder)localObject3).build());
        }
        else if (((a.b)localObject2).a == ContactsContract.CommonDataKinds.Im.class)
        {
          Log.e("viewsharedcontactactivity " + localObject2.toString());
        }
        else
        {
          Log.e("viewsharedcontactactivity/type/unknown " + localObject2.toString());
        }
      }
    }
    int j;
    if ((parama.j != null) && (parama.j.size() > 0))
    {
      localObject2 = (a.d)parama.j.get(0);
      localObject3 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
      ((ContentProviderOperation.Builder)localObject3).withValueBackReference("raw_contact_id", 0);
      ((ContentProviderOperation.Builder)localObject3).withValue("mimetype", "vnd.android.cursor.item/organization");
      j = ((a.d)localObject2).b.lastIndexOf(" ");
      if (j <= 0) {
        break label1229;
      }
    }
    label1229:
    for (localObject1 = ((a.d)localObject2).b.substring(0, j);; localObject1 = ((a.d)localObject2).b)
    {
      ((ContentProviderOperation.Builder)localObject3).withValue("data1", localObject1);
      if (j > 0) {
        ((ContentProviderOperation.Builder)localObject3).withValue("data5", ((a.d)localObject2).b.substring(j + 1));
      }
      ((ContentProviderOperation.Builder)localObject3).withValue("data4", ((a.d)localObject2).c);
      localArrayList.add(((ContentProviderOperation.Builder)localObject3).build());
      if (parama.k == null) {
        break;
      }
      localObject1 = parama.k.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (String)((Iterator)localObject1).next();
        if (((String)localObject3).equals("NICKNAME")) {
          localArrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/nickname").withValue("data1", ((a.a.a.a.a)((List)parama.k.get(localObject3)).get(0)).b).build());
        }
        if (((String)localObject3).equals("BDAY")) {
          localArrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/contact_event").withValue("data2", Integer.valueOf(3)).withValue("data1", ((a.a.a.a.a)((List)parama.k.get(localObject3)).get(0)).b).build());
        }
        if (a.a.a.a.a.a.a.containsKey(localObject3))
        {
          localObject2 = (a.a.a.a.a)((List)parama.k.get(localObject3)).get(0);
          localObject3 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/im").withValue("data5", a.a.a.a.a.a.a.get(localObject3)).withValue("data1", ((a.a.a.a.a)((List)parama.k.get(localObject3)).get(0)).b);
          if ((((a.a.a.a.a)localObject2).f != null) && (((a.a.a.a.a)localObject2).f.size() > 0)) {
            ((ContentProviderOperation.Builder)localObject3).withValue("data2", localObject2.f.toArray()[0]);
          }
          localArrayList.add(((ContentProviderOperation.Builder)localObject3).build());
        }
      }
    }
    if (paramBitmap != null)
    {
      localObject1 = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject1);
      paramBitmap = ((ByteArrayOutputStream)localObject1).toByteArray();
      localArrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", paramBitmap).build());
    }
    try
    {
      ((ByteArrayOutputStream)localObject1).close();
      try
      {
        paramBitmap = this.g.f;
        if (paramBitmap == null)
        {
          Log.w("sharecontactutil cr=null");
          return;
        }
        paramBitmap = paramBitmap.applyBatch("com.android.contacts", localArrayList)[0].uri.getLastPathSegment();
        a(paramArrayList1, paramArrayList2, parama.a(), paramBitmap);
        if (paramnh != null)
        {
          paramnh.a(0, 2131296510, new Object[] { parama.a() });
          return;
        }
      }
      catch (Exception parama)
      {
        Log.e("sharecontactutil/" + parama.toString());
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      for (;;) {}
    }
  }
  
  public final void a(Context paramContext, String paramString)
  {
    paramContext.startActivity(Conversation.a(this.a.d(paramString)));
  }
  
  public final void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, String paramString1, String paramString2)
  {
    if (paramArrayList1.size() != paramArrayList2.size())
    {
      Log.w("sharecontactutil/phones_jids_list_size_mismatch: " + paramArrayList1.size() + ", " + paramArrayList2.size());
      return;
    }
    if (!this.i.d())
    {
      Log.w("sharecontactutil/on-activity-result/access to contacts denied");
      return;
    }
    int k = 0;
    int j = 0;
    String str2;
    ArrayList localArrayList;
    int m;
    label135:
    cs localcs;
    Cursor localCursor;
    if (k < paramArrayList1.size())
    {
      str2 = (String)paramArrayList1.get(k);
      String str3 = (String)paramArrayList2.get(k);
      if (str3 != null)
      {
        localArrayList = this.a.g(str3);
        if (localArrayList.size() > 0)
        {
          Iterator localIterator = localArrayList.iterator();
          m = 0;
          while (localIterator.hasNext())
          {
            localcs = (cs)localIterator.next();
            if ((localcs.t != null) && (localcs.d == null)) {
              if ((!localcs.t.equals(str3)) || (!PhoneNumberUtils.compare(str2, str3.substring(0, str3.indexOf("@")))))
              {
                Log.w("sharecontactutil/false_match: " + localcs.t);
              }
              else
              {
                Log.i("sharecontactutil/unknown_contact_update:" + localcs);
                localCursor = this.g.f.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[] { "raw_contact_id" }, "data1 =? AND account_type =?", new String[] { str2, "com.whatsapp" }, null);
                if ((localCursor == null) || (!localCursor.moveToFirst())) {
                  break label458;
                }
              }
            }
          }
        }
      }
    }
    label458:
    for (String str1 = localCursor.getString(localCursor.getColumnIndex("raw_contact_id"));; str1 = paramString2)
    {
      if (localCursor != null) {
        localCursor.close();
      }
      localcs.d = new cs.a(Long.parseLong(str1), str2);
      localcs.e = paramString1;
      localcs.h = true;
      m = 1;
      break label135;
      if (m != 0)
      {
        this.a.c(localArrayList);
        this.e.a(bb.a(this));
      }
      for (;;)
      {
        k += 1;
        break;
        j = 1;
      }
      if (j == 0) {
        break;
      }
      Log.i("sharecontactutil/new_number/need_delta_sync");
      paramArrayList1 = new t.a(w.c).a();
      this.h.b(paramArrayList1);
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */