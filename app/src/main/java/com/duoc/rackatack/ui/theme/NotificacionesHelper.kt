package com.duoc.rackatack.ui.theme

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

fun mostrarNotificacionLevantamiento(context: Context, titulo: String, mensaje: String) {
    val channelId = "canal_levantamientos"

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val nombre = "Levantamientos RackAtack"
        val descripcion = "Notificaciones al guardar registros"
        val importancia = NotificationManager.IMPORTANCE_DEFAULT
        val canal = NotificationChannel(channelId, nombre, importancia).apply {
            description = descripcion
        }
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(canal)
    }

    val builder = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_dialog_info) // ACÁ PODEMOS CAMBAIR EL ICONOOO
        .setContentTitle(titulo)
        .setContentText(mensaje)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setAutoCancel(true)

    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED || Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
        with(NotificationManagerCompat.from(context)) {
            notify(System.currentTimeMillis().toInt(), builder.build())
        }
    }
}