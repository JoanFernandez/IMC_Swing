/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaimcswing;

import java.awt.EventQueue;

public class PracticaIMCSwing {
    public static void main(String [] args) {
	EventQueue.invokeLater(new Runnable() 
	{
            public void run() 
            {
                try {
                    new MainWindow();
		} catch (Exception e) {
		e.printStackTrace();
		}
			}
            });
	}
}
