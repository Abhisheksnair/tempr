package com.whatsapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.v4.f.h;
import com.whatsapp.registration.bk;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class atv
{
  private static volatile atv b;
  public final SharedPreferences a;
  private final Context c;
  private final Object d = new Object();
  private final Object e = new Object();
  
  private atv(Context paramContext)
  {
    this.c = paramContext;
    this.a = paramContext.getSharedPreferences("com.whatsapp_preferences", 0);
  }
  
  public static atv a()
  {
    if (b == null) {}
    try
    {
      b = new atv(u.a());
      return b;
    }
    finally {}
  }
  
  private static List<h<String, Integer>> ah()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(h.a("security_notifications", Integer.valueOf(1)));
    localArrayList.add(h.a("input_enter_send", Integer.valueOf(1)));
    localArrayList.add(h.a("interface_font_size", Integer.valueOf(2)));
    localArrayList.add(h.a("settings_language", Integer.valueOf(2)));
    localArrayList.add(h.a("conversation_sound", Integer.valueOf(1)));
    localArrayList.add(h.a("autodownload_wifi_mask", Integer.valueOf(0)));
    localArrayList.add(h.a("autodownload_cellular_mask", Integer.valueOf(0)));
    localArrayList.add(h.a("autodownload_roaming_mask", Integer.valueOf(0)));
    localArrayList.add(h.a("voip_low_data_usage", Integer.valueOf(1)));
    localArrayList.add(h.a("show_all_contacts", Integer.valueOf(1)));
    return localArrayList;
  }
  
  public final float A()
  {
    return this.a.getFloat("pref_hist_echo", -1.0F);
  }
  
  public final boolean B()
  {
    return (this.a.contains("video_call_back_camera_width")) || (this.a.contains("video_call_back_camera_height"));
  }
  
  public final boolean C()
  {
    return (this.a.contains("video_call_front_camera_width")) || (this.a.contains("video_call_front_camera_height"));
  }
  
  public final int D()
  {
    return this.a.getInt("video_call_pip_position", -1);
  }
  
  public final String E()
  {
    return this.a.getString("change_number_new_number_banned", null);
  }
  
  public final String F()
  {
    return this.a.getString("cc", "");
  }
  
  public final String G()
  {
    return this.a.getString("ph", "");
  }
  
  public final String H()
  {
    return this.a.getString("com.whatsapp.registration.RegisterPhone.mistyped_state", null);
  }
  
  public final String I()
  {
    return this.a.getString("c2dm_reg_id", null);
  }
  
  public final int J()
  {
    return this.a.getInt("c2dm_app_vers", 0);
  }
  
  public final void K()
  {
    Log.i("wa-shared-preferences/cleangcmregsettings");
    c().remove("c2dm_reg_id").remove("c2dm_app_vers").apply();
  }
  
  public final long L()
  {
    return this.a.getLong("tos_accepted_time", 0L);
  }
  
  public final int M()
  {
    return this.a.getInt("tos_current_stage_id", 0);
  }
  
  public final boolean N()
  {
    return this.a.getBoolean("tos_opted_out", false);
  }
  
  public final int O()
  {
    return this.a.getInt("call_confirmation_dialog_count", 0);
  }
  
  final void P()
  {
    PreferenceManager.setDefaultValues(this.c, 2131099654, true);
    PreferenceManager.setDefaultValues(this.c, 2131099655, true);
    PreferenceManager.setDefaultValues(this.c, 2131099656, true);
    PreferenceManager.setDefaultValues(this.c, 2131099657, true);
    PreferenceManager.setDefaultValues(this.c, 2131099658, true);
  }
  
  public final int Q()
  {
    return this.a.getInt("gdrive_error_code", 10);
  }
  
  public final int R()
  {
    try
    {
      int i = Integer.parseInt(this.a.getString("interface_gdrive_backup_frequency", "0"));
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Log.d("wa-shared-preferences/get-backup-freq", localNumberFormatException);
    }
    return 0;
  }
  
  public final boolean S()
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.remove("gdrive_already_downloaded_bytes");
    localEditor.remove("gdrive_restore_notification_visibility");
    localEditor.remove("gdrive_restore_overwrite_local_files");
    localEditor.remove("gdrive_restore_start_timestamp");
    localEditor.remove("gdrive_media_restore_network_setting");
    localEditor.remove("gdrive_approx_media_download_size");
    if (!localEditor.commit())
    {
      Log.w("wa-shared-preferences/cleanup-after-media-restore failed to commit.");
      return false;
    }
    return true;
  }
  
  public final boolean T()
  {
    return this.a.getBoolean("gdrive_restore_overwrite_local_files", false);
  }
  
  public final long U()
  {
    return this.a.getLong("gdrive_restore_start_timestamp", -1L);
  }
  
  public final int V()
  {
    try
    {
      int i = Integer.parseInt(this.a.getString("gdrive_media_restore_network_setting", "0"));
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Log.d("wa-shared-preferences/get-media-restore-network-setting", localNumberFormatException);
    }
    return 0;
  }
  
  public final boolean W()
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putString("gdrive_media_restore_network_setting", "1");
    if (!localEditor.commit())
    {
      Log.w("wa-shared-preferences/set-media-restore-network-setting unable to commit");
      return false;
    }
    return true;
  }
  
  public final boolean X()
  {
    return this.a.getBoolean("gdrive_user_initiated_backup", false);
  }
  
  public final int Y()
  {
    return this.a.getInt("gdrive_successive_backup_failed_count", 0);
  }
  
  public final boolean Z()
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putInt("gdrive_successive_backup_failed_count", 0);
    if (!localEditor.commit())
    {
      Log.w("wa-shared-preferences/reset-backup-failed-count unable to commit backup failed count to shared prefs");
      return false;
    }
    return true;
  }
  
  public final long a(long paramLong)
  {
    SharedPreferences.Editor localEditor = c();
    localEditor.putLong("contact_sync_backoff", paramLong);
    localEditor.apply();
    return this.a.getLong("contact_sync_backoff", -1L);
  }
  
  public final void a(int paramInt)
  {
    Log.d("wa-shared-prefs/setlogincountwithmsgs " + paramInt);
    c().putInt("logins_with_messages", paramInt).apply();
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (b(paramInt1) == paramInt2) {
      return;
    }
    String str;
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("network_type not valid");
    case 1: 
      str = "autodownload_wifi_mask";
    }
    for (;;)
    {
      c().putInt(str, paramInt2).apply();
      return;
      str = "autodownload_cellular_mask";
      continue;
      str = "autodownload_roaming_mask";
    }
  }
  
  public final void a(int paramInt, long paramLong)
  {
    c().putLong("tos_stage_start_time" + paramInt, paramLong).apply();
  }
  
  public final void a(bk parambk)
  {
    if (parambk != null)
    {
      this.a.edit().putBoolean("pref_fail_too_many", parambk.b).putBoolean("pref_no_route_sms", parambk.c).putBoolean("pref_no_route_voice", parambk.d).putBoolean("pref_fail_too_many_attempts", parambk.e).putBoolean("pref_fail_too_many_guesses", parambk.f).apply();
      return;
    }
    this.a.edit().remove("pref_fail_too_many").remove("pref_no_route_sms").remove("pref_no_route_voice").remove("pref_fail_too_many_attempts").remove("pref_fail_too_many_guesses").apply();
  }
  
  public final void a(String paramString)
  {
    Log.d("wa-shared-prefs/reset-permission-requested " + paramString);
    c().remove(paramString).apply();
  }
  
  public final void a(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = c();
    if (paramString != null) {
      localEditor.putString("mms_authority_override", paramString + "|" + paramLong);
    }
    for (;;)
    {
      localEditor.apply();
      return;
      localEditor.remove("mms_authority_override");
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    c().putString("cc", paramString1).putString("ph", paramString2).apply();
  }
  
  public final void a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.a.edit().putString("registration_wipe_type", paramString1).putString("registration_wipe_token", paramString2).putLong("registration_wipe_wait", paramLong1).putLong("registration_wipe_expiry", paramLong2).putLong("registration_wipe_server_time", paramLong3).putLong("registration_wipe_info_timestamp", paramLong4).apply();
  }
  
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    c().putString("aec_os_version", paramString1).putString("aec_uuid", paramString2).putString("aec_implementor", paramString3).apply();
  }
  
  public final void a(boolean paramBoolean)
  {
    Log.d("wa-shared-prefs/setallcontacts " + paramBoolean);
    c().putBoolean("show_all_contacts", paramBoolean).apply();
  }
  
  public final void a(boolean paramBoolean, long paramLong)
  {
    c().putBoolean("spam_banned", paramBoolean).putLong("spam_banned_expiry_timestamp", paramLong).apply();
    Log.d("wa-shared-prefs/setspambanned " + paramBoolean);
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    SharedPreferences.Editor localEditor = c();
    Iterator localIterator = ah().iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      String str = (String)localh.a;
      int i = ((Integer)localh.b).intValue();
      if (paramJSONObject.has(str)) {
        switch (i)
        {
        default: 
          break;
        case 0: 
          try
          {
            localEditor.putInt(str, paramJSONObject.getInt(str));
          }
          catch (JSONException localJSONException1)
          {
            Log.d("wa-shared-preferences/set-local-settings/error-while-inserting " + str + ":" + this.a.getInt(str, 0), localJSONException1);
          }
          break;
        case 1: 
          try
          {
            localEditor.putBoolean(str, paramJSONObject.getBoolean(str));
          }
          catch (JSONException localJSONException2)
          {
            Log.d("wa-shared-preferences/set-local-settings/error-while-inserting " + str + ":" + this.a.getBoolean(str, false), localJSONException2);
          }
          break;
        case 2: 
          try
          {
            localEditor.putString(str, paramJSONObject.getString(str));
          }
          catch (JSONException localJSONException3)
          {
            Log.d("wa-shared-preferences/set-local-settings/error-while-inserting " + str + ":" + this.a.getString(str, null), localJSONException3);
          }
        }
      }
    }
    if (!localEditor.commit())
    {
      Log.w("wa-shared-preferences/set-local-settings/failed-to-commit");
      return false;
    }
    return true;
  }
  
  public final int aa()
  {
    return this.a.getInt("gdrive_state", 0);
  }
  
  public final void ab()
  {
    Log.i("wa-shared-preferences/reset-backup-primary-base-folder-id");
    if (!this.a.edit().remove("gdrive_primary_base_folder_id").commit()) {
      Log.w("wa-shared-preferences/reset-backup-primary-base-folder-id unable to commit the changes");
    }
  }
  
  public final String ac()
  {
    return this.a.getString("gdrive_account_name", null);
  }
  
  public final int ad()
  {
    try
    {
      int i = Integer.parseInt(this.a.getString("interface_gdrive_backup_network_setting", "0"));
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Log.d("wa-shared-preferences/get-backup-network-settings", localNumberFormatException);
    }
    return 0;
  }
  
  public final boolean ae()
  {
    return this.a.getBoolean("gdrive_include_videos_in_backup", false);
  }
  
  public final String af()
  {
    return this.a.getString("registration_jid", null);
  }
  
  public final String ag()
  {
    return this.a.getString("registration_biz_certificate_id", null);
  }
  
  public final int b(int paramInt)
  {
    int i = 0;
    int j = 0;
    String str;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("network_type not valid");
    case 1: 
      str = "autodownload_wifi_mask";
      paramInt = 15;
    }
    for (;;)
    {
      i = this.a.getInt(str, paramInt);
      return i;
      str = "autodownload_cellular_mask";
      paramInt = 1;
      continue;
      str = "autodownload_roaming_mask";
      paramInt = j;
    }
  }
  
  public final long b(long paramLong)
  {
    SharedPreferences.Editor localEditor = c();
    localEditor.putLong("status_sync_backoff", paramLong);
    localEditor.apply();
    return this.a.getLong("status_sync_backoff", -1L);
  }
  
  public final void b(String paramString)
  {
    SharedPreferences.Editor localEditor = c();
    if (paramString == null) {
      localEditor.remove("my_current_status");
    }
    for (;;)
    {
      localEditor.apply();
      return;
      localEditor.putString("my_current_status", paramString);
    }
  }
  
  public final void b(String paramString, long paramLong)
  {
    if (paramString == null) {
      Log.e("wa-shared-preferences/set-scrub-timestamp this is weird, next scrub timestamp is set to " + paramLong + " but accountName associated is null, ignoring.");
    }
    SharedPreferences.Editor localEditor;
    do
    {
      return;
      localEditor = this.a.edit();
      localEditor.putLong("gdrive_next_scrub_timestamp:" + paramString, paramLong);
    } while (localEditor.commit());
    Log.w("wa-shared-preferences/set-scrub-timestamp unable to commit next scrub timestamp to shared prefs");
  }
  
  public final void b(boolean paramBoolean)
  {
    c().putBoolean("refresh_broadcast_lists", paramBoolean).apply();
  }
  
  public final boolean b()
  {
    return this.a.getBoolean("show_all_contacts", false);
  }
  
  public final long c(long paramLong)
  {
    SharedPreferences.Editor localEditor = c();
    localEditor.putLong("feature_sync_backoff", paramLong);
    localEditor.apply();
    return this.a.getLong("feature_sync_backoff", -1L);
  }
  
  public final SharedPreferences.Editor c()
  {
    return this.a.edit();
  }
  
  public final void c(int paramInt)
  {
    Log.d("wa-shared-preferences/setdeletechat " + paramInt);
    c().putInt("delete_chat_count", paramInt).apply();
  }
  
  public final void c(String paramString)
  {
    c().putString("push_name", paramString).apply();
  }
  
  public final void c(boolean paramBoolean)
  {
    Log.d("wa-shared-prefs/set-has-had-bkgnd-off " + paramBoolean);
    c().putBoolean("has_had_background_data_disabled", paramBoolean).apply();
  }
  
  public final boolean c(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      Log.e("wa-shared-preferences/set-backup-timestamp this is weird, last successful backup timestamp is set to " + paramLong + " but accountName associated is null, ignoring.");
      return false;
    }
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putLong("gdrive_last_successful_backup_timestamp:" + paramString, paramLong);
    if (!localEditor.commit())
    {
      Log.w("wa-shared-preferences/set-backup-timestamp unable to commit backup timestamp to shared prefs");
      return false;
    }
    return true;
  }
  
  public final int d()
  {
    int i = this.a.getInt("logins_with_messages", 0);
    Log.d("wa-shared-prefs/getlogincountwithmsgs " + i);
    return i;
  }
  
  public final void d(int paramInt)
  {
    c().putInt("skin_emoji_tip", paramInt).apply();
  }
  
  public final void d(long paramLong)
  {
    c().putLong("anr_file_timestamp", paramLong).apply();
  }
  
  public final void d(String paramString)
  {
    c().putString("routing_info_dns", paramString).apply();
  }
  
  public final void d(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = c();
    localEditor.putBoolean("wam_is_current_buffer_real_time", paramBoolean);
    localEditor.apply();
  }
  
  public final boolean d(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      Log.e("wa-shared-preferences/set-total-backup-size account name is null");
      return false;
    }
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putLong("gdrive_last_successful_backup_total_size:" + paramString, paramLong);
    if (!localEditor.commit())
    {
      Log.w("wa-shared-preferences/set-total-backup-size unable to commit");
      return false;
    }
    return true;
  }
  
  public final long e(String paramString)
  {
    long l1;
    if (paramString == null)
    {
      Log.w("wa-shared-preferences/get-backup-timestamp accountName passed is null.");
      l1 = 0L;
    }
    long l2;
    do
    {
      do
      {
        do
        {
          return l1;
          l2 = this.a.getLong("gdrive_last_successful_backup_timestamp:" + paramString, 0L);
          l1 = l2;
        } while (l2 != 0L);
        l2 = this.a.getLong("gdrive_last_successful_backup_timestamp", 0L);
        l1 = l2;
      } while (l2 == 0L);
      c(paramString, l2);
      paramString = this.a.edit();
      paramString.remove("gdrive_last_successful_backup_timestamp");
      l1 = l2;
    } while (paramString.commit());
    Log.w("wa-shared-preferences/get-backup-timestamp unable to delete old key gdrive_last_successful_backup_timestamp, this error can be ignored.");
    return l2;
  }
  
  public final void e(int paramInt)
  {
    c().putInt("video_call_pip_position", paramInt).apply();
  }
  
  public final void e(long paramLong)
  {
    c().putLong("registration_start_time", paramLong).apply();
  }
  
  public final void e(boolean paramBoolean)
  {
    Log.i("wa-shared-prefs/setshouldgetprekeydigest/" + paramBoolean);
    synchronized (this.d)
    {
      c().putBoolean("need_to_get_pre_key_digest", paramBoolean).apply();
      return;
    }
  }
  
  public final boolean e()
  {
    return this.a.getBoolean("read_receipts_enabled", true);
  }
  
  public final boolean e(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      Log.e("wa-shared-preferences/set-backup-video-size account name is null");
      return false;
    }
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putLong("gdrive_last_successful_backup_video_size:" + paramString, paramLong);
    if (!localEditor.commit())
    {
      Log.w("wa-shared-preferences/set-backup-video-size unable to commit");
      return false;
    }
    return true;
  }
  
  public final long f()
  {
    return this.a.getLong("last_contact_full_sync", -1L);
  }
  
  public final long f(String paramString)
  {
    return this.a.getLong("gdrive_last_successful_backup_total_size:" + paramString, -1L);
  }
  
  public final void f(int paramInt)
  {
    c().putInt("tos_current_stage_id", paramInt).apply();
  }
  
  public final void f(long paramLong)
  {
    c().putLong("client_server_time_diff", paramLong).apply();
  }
  
  public final void f(boolean paramBoolean)
  {
    Log.i("wa-shared-prefs/setsignalprotocolstoreisnew/" + paramBoolean);
    synchronized (this.e)
    {
      c().putBoolean("signal_protocol_store_is_new", paramBoolean).apply();
      return;
    }
  }
  
  public final long g()
  {
    return this.a.getLong("contact_full_sync_wait", 86400000L);
  }
  
  public final long g(int paramInt)
  {
    return this.a.getLong("tos_stage_start_time" + paramInt, 0L);
  }
  
  public final void g(long paramLong)
  {
    c().putLong("dithered_last_signed_prekey_rotation", paramLong).apply();
  }
  
  public final void g(boolean paramBoolean)
  {
    c().putBoolean("new_jid", paramBoolean).apply();
  }
  
  public final boolean g(String paramString)
  {
    ab();
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putString("gdrive_account_name", paramString);
    if (!localEditor.commit())
    {
      Log.w("wa-shared-preferences/set-account-name unable to commit account name to shared prefs");
      return false;
    }
    return true;
  }
  
  public final long h()
  {
    return this.a.getLong("contact_sync_backoff", -1L);
  }
  
  public final void h(long paramLong)
  {
    c().putLong("last_heartbeat_login", paramLong).apply();
  }
  
  public final void h(String paramString)
  {
    this.a.edit().putString("registration_code", paramString).apply();
  }
  
  public final void h(boolean paramBoolean)
  {
    Log.i("wa-shared-preferences/setshouldgetgroups " + paramBoolean);
    c().putBoolean("need_to_get_groups", paramBoolean).apply();
  }
  
  public final boolean h(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      Log.e("wa-shared-preferences/set-backup-freq/" + paramInt);
      return false;
    }
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putString("interface_gdrive_backup_frequency", String.valueOf(paramInt));
    if (!localEditor.commit())
    {
      Log.w("wa-shared-preferences/set-backup-freq unable to commit");
      return false;
    }
    return true;
  }
  
  public final long i()
  {
    return this.a.getLong("status_sync_backoff", -1L);
  }
  
  public final void i(long paramLong)
  {
    this.a.edit().putLong("gdrive_already_downloaded_bytes", paramLong).apply();
  }
  
  public final void i(String paramString)
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    if (paramString == null) {
      localEditor.remove("registration_biz_certificate_id");
    }
    for (;;)
    {
      localEditor.apply();
      return;
      localEditor.putString("registration_biz_certificate_id", paramString);
    }
  }
  
  public final boolean i(int paramInt)
  {
    Log.i("wa-shared-preferences/set-gdrive-state/" + paramInt);
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putInt("gdrive_state", paramInt);
    if (!localEditor.commit())
    {
      Log.w("wa-shared-preferences/set-drive-state unable to commit google drive state to shared prefs");
      return false;
    }
    return true;
  }
  
  public final boolean i(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putBoolean("gdrive_restore_overwrite_local_files", paramBoolean);
    if (!localEditor.commit())
    {
      Log.w("wa-shared-preferences/restore-overwrite-local-files unable to commit overwrite local files to shared prefs");
      return false;
    }
    return true;
  }
  
  public final int j(int paramInt)
  {
    return this.a.getInt("registration_state", paramInt);
  }
  
  public final long j()
  {
    return this.a.getLong("feature_sync_backoff", -1L);
  }
  
  public final boolean j(long paramLong)
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putLong("gdrive_restore_start_timestamp", paramLong);
    if (!localEditor.commit())
    {
      Log.w("wa-shared-preferences/set-restore-start-timestamp unable to commit restore start timestamp to shared prefs");
      return false;
    }
    return true;
  }
  
  public final boolean j(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putBoolean("gdrive_user_initiated_backup", paramBoolean);
    if (!localEditor.commit())
    {
      Log.w("wa-shared-preferences/set-backup-user-initiated unable to commit");
      return false;
    }
    return true;
  }
  
  public final void k()
  {
    a(-1L);
    b(-1L);
    c(-1L);
  }
  
  public final void k(int paramInt)
  {
    this.a.edit().putInt("registration_voice_code_length", paramInt).apply();
  }
  
  public final boolean k(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putBoolean("gdrive_include_videos_in_backup", paramBoolean);
    if (!localEditor.commit())
    {
      Log.w("wa-shared-preferences/set-backup-include-videos/" + paramBoolean + " unable to commit");
      return false;
    }
    return true;
  }
  
  public final String l()
  {
    return this.a.getString("push_name", "");
  }
  
  public final void l(int paramInt)
  {
    this.a.edit().putInt("registration_sms_code_length", paramInt).apply();
  }
  
  public final void l(boolean paramBoolean)
  {
    this.a.edit().putBoolean("live_location_is_new_user", paramBoolean).apply();
  }
  
  final String m()
  {
    String str = this.a.getString("mms_authority_override", null);
    if (str == null) {
      return null;
    }
    String[] arrayOfString = str.split("\\|");
    if (arrayOfString.length != 2)
    {
      Log.w("wa-shared-prefs/get_mms_authority_override/garbage " + str);
      a(null, 0L);
      return null;
    }
    try
    {
      if (Long.parseLong(arrayOfString[1]) <= System.currentTimeMillis())
      {
        a(null, 0L);
        return null;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Log.w("wa-shared-prefs/get_mms_authority_override/bad_expiry " + arrayOfString[1]);
      a(null, 0L);
      return null;
    }
    return arrayOfString[0];
  }
  
  public final void m(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    if (paramBoolean) {
      localEditor.putBoolean("registration_biz_user_confirmed_certificate", true);
    }
    for (;;)
    {
      localEditor.apply();
      return;
      localEditor.remove("registration_biz_user_confirmed_certificate");
    }
  }
  
  public final boolean n()
  {
    synchronized (this.d)
    {
      boolean bool = this.a.getBoolean("need_to_get_pre_key_digest", true);
      return bool;
    }
  }
  
  public final boolean o()
  {
    synchronized (this.e)
    {
      boolean bool = this.a.getBoolean("signal_protocol_store_is_new", false);
      return bool;
    }
  }
  
  public final void p()
  {
    c().remove("last_upgrade_remote_sha256").apply();
  }
  
  public final aqh q()
  {
    Object localObject = this.a.getString("video_transcode_saved_local_config", null);
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      localObject = new aqh(((JSONObject)localObject).optString("media_codec_encoder", null), ((JSONObject)localObject).optString("media_codec_decoder", null), ((JSONObject)localObject).optInt("color_format_encoder", -1), ((JSONObject)localObject).optInt("color_format_decoder", -1), ((JSONObject)localObject).optInt("forced_frame_conv_id_encoder", -1), ((JSONObject)localObject).optInt("forced_frame_conv_id_decoder", -1));
      return (aqh)localObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public final int r()
  {
    return this.a.getInt("delete_chat_count", 0);
  }
  
  public final int s()
  {
    return this.a.getInt("create_group_tip_count", 0);
  }
  
  public final long t()
  {
    return this.a.getLong("registration_start_time", -1L);
  }
  
  public final int u()
  {
    int i = this.a.getInt("contact_version", 0);
    Log.i("wa-shared-preferences/getversion=" + i);
    return i;
  }
  
  public final boolean v()
  {
    return this.a.getBoolean("voip_low_data_usage", false);
  }
  
  public final JSONObject w()
  {
    Object localObject = ah();
    JSONObject localJSONObject = new JSONObject();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      h localh = (h)((Iterator)localObject).next();
      String str = (String)localh.a;
      int i = ((Integer)localh.b).intValue();
      if (this.a.contains(str)) {
        switch (i)
        {
        default: 
          throw new IllegalStateException("Unexpected key type: " + str + " " + i);
        case 0: 
          try
          {
            localJSONObject.put(str, this.a.getInt(str, 0));
          }
          catch (JSONException localJSONException1)
          {
            Log.d("wa-shared-preferences/get-local-settings/error-while-inserting " + str + ":" + this.a.getInt(str, 0), localJSONException1);
          }
          break;
        case 1: 
          try
          {
            localJSONObject.put(str, this.a.getBoolean(str, false));
          }
          catch (JSONException localJSONException2)
          {
            Log.d("wa-shared-preferences/get-local-settings/error-while-inserting " + str + ":" + this.a.getBoolean(str, false), localJSONException2);
          }
          break;
        case 2: 
          try
          {
            localJSONObject.put(str, this.a.getString(str, null));
          }
          catch (JSONException localJSONException3)
          {
            Log.d("wa-shared-preferences/get-local-settings/error-while-inserting " + str + ":" + this.a.getString(str, null), localJSONException3);
          }
        }
      }
    }
    return localJSONObject;
  }
  
  public final long x()
  {
    return this.a.getLong("dithered_last_signed_prekey_rotation", Long.MIN_VALUE);
  }
  
  public final int y()
  {
    return this.a.getInt("decryption_failure_views", 0);
  }
  
  public final int z()
  {
    return this.a.getInt("call_offer_ack_timeout", 20000);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/atv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */