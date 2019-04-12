package com.zmj.viewpagertest.downloadprocess;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 *下载数据Service类
 */
public class DownloadService extends Service {

    public DownloadService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
