package com.zmj.viewpagertest.downloadprocess;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

/**
 *下载数据Service类
 */
public class DownloadService extends Service {

    private DownloadTask downloadTask;
    private String downLoadUrl;

    private DownloadListener listener = new DownloadListener() {
        @Override
        public void onProgress(int progress) {

        }

        @Override
        public void onSuccess() {

        }

        @Override
        public void onFailed() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onCanceled() {

        }
    };

    private DownloadBinder mBinder = new DownloadBinder();

    @Override
    public IBinder onBind(Intent intent) {
        //throw new UnsupportedOperationException("Not yet implemented");
        return mBinder;
    }

    class DownloadBinder extends Binder {
        public void startDownload(String url){
            if (downloadTask == null){
                downLoadUrl = url;
                downloadTask = new DownloadTask(listener);
                downloadTask.execute(downLoadUrl);
                startForeground(1,getNotification("Downloading...",0));
                Toast.makeText(DownloadService.this,"Downloading...",Toast.LENGTH_SHORT).show();
            }
        }

        private Notification getNotification(String title,int progress){
            return null;
        }

    }
}
