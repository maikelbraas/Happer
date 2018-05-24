import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
public class Main {
	
	public static void main(String[] args) {
		// set up the shell
		Display display = new Display();
		Image player = new Image(display,"C:/Users/Maikel/Documents/sheet/player character/base.png");
		Image obstacles = new Image(display,"C:/Users/Maikel/Documents/sheet/tilemap/tilemap.png");
		Image enemie = new Image(display,"C:/Users/Maikel/Documents/sheet/enemies/enbase.png");
		Shell shell = new Shell();
		shell.setSize(298, 321);
		shell.setText("Happer");
		shell.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				int rowCount = 0;
				for(int i = 1; i < 282; i+=40) {
					if(i < 280) {
				        e.gc.drawRectangle(i-1,rowCount,41, 41);
				        e.gc.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
				        e.gc.fillRectangle(i,rowCount+1,40,40);
				        // Player image, srcx, srcy, srcw, srch, x, y, w, h
						e.gc.drawImage(player, 0, 0, 40, 40, 0, 0, 40, 40);
						// Boxes 		image, 	srcx,srcy,srcw,srch,x,y,w, h
						e.gc.drawImage(obstacles, 32, 228, 32, 32, 0, 80, 40, 40);
						e.gc.drawImage(obstacles, 32, 228, 32, 32, 120, 120, 40, 40);
						e.gc.drawImage(obstacles, 32, 228, 32, 32, 240, 80, 40, 40);
						e.gc.drawImage(obstacles, 32, 228, 32, 32, 80, 200, 40, 40);
						// Blocks image, srcx, srcy, srcw, srch, x, y, w, h
						e.gc.drawImage(obstacles, 352, 128, 32, 32, 200, 40, 40, 40);
						e.gc.drawImage(obstacles, 352, 128, 32, 32, 120, 160, 40, 40);
						// Enemie image, srcx, srcy, srcw, srch, x, y, w, h
						e.gc.drawImage(enemie, 0, 0, 32, 32, 240, 240, 40, 40);
					} else if(rowCount < 240) {
						i = -39;
						rowCount+=40;
					}
				}
			}
		});
		// add widgets to the shell
		
		// give the program time to handle UI events.
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		// clean up when done
		shell.dispose();
	}
	
}
