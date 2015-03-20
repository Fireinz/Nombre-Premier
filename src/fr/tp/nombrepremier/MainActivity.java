package fr.tp.nombrepremier;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button boutonJ;
	EditText editTextNombre;
	Button boutonJavaList;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// récupération de l'élément EditText (nb1)
		editTextNombre = (EditText) this.findViewById(R.id.nb1);
		editTextNombre.setText("");
		
		// récupération du bouton (buttonJava)
		boutonJ = (Button) this.findViewById(R.id.buttonJava);
		boutonJ.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	//int n, status = 1, num = 3;
        	if (editTextNombre.getText().length() > 0){ 
        		
        		// Démarre le compteur
        		long tStart = System.currentTimeMillis();
                int recupNbrEditText = Integer.parseInt(editTextNombre.getText().toString());
                // Stop le compteur
                long tEnd = System.currentTimeMillis();
                long tDelta = tEnd - tStart;
                double elapsedSeconds = tDelta / 1000.0;  
                
	            	if (estPremier(recupNbrEditText)){	            			            	
	            		Toast.makeText(MainActivity.this, "Nbr premier !", Toast.LENGTH_SHORT).show();
	            		Toast.makeText(MainActivity.this, "Exécuté en : " + String.valueOf(elapsedSeconds) + " s", Toast.LENGTH_SHORT).show();
	            	}else{
	            		Toast.makeText(MainActivity.this,"N'est pas nbr premier" , Toast.LENGTH_SHORT).show();
	            		Toast.makeText(MainActivity.this, "Exécuté en : " + String.valueOf(elapsedSeconds) + " s", Toast.LENGTH_SHORT).show();
	            	}
            	}else{
            		
            		Toast.makeText(MainActivity.this,"Veuillez entrer une valeur." , Toast.LENGTH_SHORT).show();
            	}
                
                
            }
        });
		
		// Action sur le bouton java LIST
		boutonJavaList = (Button) this.findViewById(R.id.buttonJavaList);
		boutonJavaList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	if (editTextNombre.getText().length() > 0){
            		// Démarre le compteur
            		long tStart = System.currentTimeMillis();
                	String listNombrePremier = "" ;
                    int recupNbrEditText = Integer.parseInt(editTextNombre.getText().toString());
                	int compteur = 0;                	
                	
                    // Parcours la liste jusqu'au nombre demandé
                    for(int i = 2; i <= recupNbrEditText; i++){
                    	if (estPremier(i)){
                    		listNombrePremier += String.valueOf(i) + ",";
                    		compteur++;
                    	}
                    }
                    // Stop le compteur
                    long tEnd = System.currentTimeMillis();
                    long tDelta = tEnd - tStart;
                    double elapsedSeconds = tDelta / 1000.0;                                   
                	if (compteur > 0){
                		Toast.makeText(MainActivity.this, listNombrePremier, Toast.LENGTH_SHORT).show();
                		Toast.makeText(MainActivity.this, "Exécuté en : " + String.valueOf(elapsedSeconds) + " s", Toast.LENGTH_SHORT).show();
                	}else{
                		Toast.makeText(MainActivity.this,"Aucun nbr premier, so bad :(" , Toast.LENGTH_SHORT).show();
                	}
                	
            	}else{
            		Toast.makeText(MainActivity.this,"Veuillez entrer une valeur." , Toast.LENGTH_SHORT).show();
            	}
            }
        });		
		
	}
	
	public boolean estPremier(int nbr){
		
		if (nbr >= 2){	
	        // Formule pour savoir si c'est un nbr premier
			for(long i = 2 ; i < nbr ; i++){
	            if(nbr%i == 0){
	                return false;
	            }
			}
	        return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
