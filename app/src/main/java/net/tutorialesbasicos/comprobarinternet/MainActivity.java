package net.tutorialesbasicos.comprobarinternet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView mitexto = (TextView) findViewById(R.id.mitexto);

       //Aqui llamamos a la funcion para comprobar si hay internet
        if (!compruebaConexion(this)) {
            Toast.makeText(getBaseContext(), "Necesaria conexión a internet ", Toast.LENGTH_SHORT).show();
            mitexto.setText("NO HAY CONEXION A INTERNET");
        }
            else{
            mitexto.setText("SI HAY CONEXION A INTERNET");
            Toast.makeText(getBaseContext(), "Esta conectado a internet ", Toast.LENGTH_SHORT).show();

        }
    }


    //Función para cequear el internet
    public static boolean compruebaConexion(Context context) {
        boolean connected = false;
        ConnectivityManager connec = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // Recupera todas las redes (tanto móviles como wifi)
        NetworkInfo[] redes = connec.getAllNetworkInfo();
        for (int i = 0; i < redes.length; i++) {
            // Si alguna red tiene conexión, se devuelve true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                connected = true;
            }
        }
        return connected;
    }
}
