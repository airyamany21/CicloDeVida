package curso.uabc.com.ciclodevida;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;



/**
 * Created by xhendor on 4/2/15.
 * Este activity hereda los atributos y metodos de ActionBarActivity,
 * el objetivo principal de esta clase es crear notificaciones del ciclo de vida de una aplicacion Android
 *
 */


    public class TracerActivity extends ActionBarActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            notify("onCreate");
        }

        @Override
        protected void onPause() {
            super.onPause();
            notify("onPause");
        }

        @Override
        protected void onResume() {
            super.onResume();
            notify("onResume");
        }

        @Override
        protected void onStop() {
            super.onStop();
            notify("onStop");
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            notify("onDestroy");
        }

        @Override
        protected void onRestoreInstanceState(Bundle savedInstanceState) {
            super.onRestoreInstanceState(savedInstanceState);
            notify("onRestoreInstanceState");
        }

        @Override
        protected void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            notify("onSaveInstanceState");
        }


        /**
         * Este metodo notify tiene la funcion de crear notificaciones al ejecuarse algun metodo del ciclo de vida de las aplicaciones Android.
         * */
        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        private void notify(String methodName) {

            //Obtiene el nombre de la clase ya sea OnDestroy, OnPause etc.
            String name = this.getClass().getName();
            //Corta el texto del  NOMBRE.CLASS dejando solo NOMBRE
            String[] strings = name.split("\\.");
            //Crea una notificacion con el Builder del sistema, tomcando como imagen el icono de la aplicacion y como mensaje el metodo que se llamo.
            Notification noti = new Notification.Builder(this)
                    .setContentTitle(methodName + " " + strings[strings.length - 1]).setAutoCancel(true)
                    .setSmallIcon(R.drawable.ic_launcher)
                    .setContentText(name).build();
            //Una vez construida se llama una instancia del sistema del manejador de notificaciones (NotificationManager), para registrar la notificacion.
            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify((int) System.currentTimeMillis(), noti);
        }

    }

