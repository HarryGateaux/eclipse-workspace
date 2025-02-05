package module6;

import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PGraphics;

/** 
 * A class to represent AirportMarkers on a world map.
 *   
 * @author Adam Setters and the UC San Diego Intermediate Software Development
 * MOOC team
 *
 */
public class AirportMarker extends CommonMarker implements Comparable<AirportMarker> {
	public static List<SimpleLinesMarker> routes;
	public int routeCount;
	
	public int compareTo(AirportMarker marker) {

		float test = marker.routeCount - this.routeCount;

		if (test < 0) {
			return -1;
		} else if (test > 0) {
			return 1;
		} else
			return 0;
	}
	
	public void setRouteCount(int x)	{
		this.routeCount = x;
	}
	
	public AirportMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
	
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		pg.fill(pg.color(255));
		pg.ellipse(x, y, radius, radius);
		
		
	}

	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		 // show rectangle with title
		
		// show routes
		
		
	}
	
}
