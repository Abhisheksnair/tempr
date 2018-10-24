package com.whatsapp.contact.sync;

import android.database.DatabaseUtils;

public enum p
{
  public final String[] d;
  
  private p(String[] paramArrayOfString)
  {
    this.d = paramArrayOfString;
  }
  
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    localStringBuilder.append("account_type");
    localStringBuilder.append(" IS NULL OR ");
    localStringBuilder.append("account_type");
    localStringBuilder.append("!=");
    DatabaseUtils.appendEscapedSQLString(localStringBuilder, "com.whatsapp");
    localStringBuilder.append(')');
    if (this.d != null)
    {
      localStringBuilder.append(" AND ");
      localStringBuilder.append("in_visible_group");
      localStringBuilder.append("=?");
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/contact/sync/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */