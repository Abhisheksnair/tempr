package com.whatsapp;

import com.google.android.search.verification.client.SearchActionVerificationClientActivity;
import com.google.android.search.verification.client.SearchActionVerificationClientService;

public class VoiceMessagingActivity
  extends SearchActionVerificationClientActivity
{
  public Class<? extends SearchActionVerificationClientService> getServiceClass()
  {
    return VoiceMessagingService.class;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/VoiceMessagingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */