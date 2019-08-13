package com.firestarter.kinematicskode.utilities;

import java.util.ArrayList;

public class Calculator {
	private Double vi, vf, a, d, t;
	private ArrayList<String> solve;
	
	public Calculator() {
		solve = new ArrayList<String>();
	}
	
	public void update(Double vi, Double vf, Double a, Double d, Double t) {
		this.vi = vi;
		this.vf = vf;
		this.a = a;
		this.d = d;
		this.t = t;
	}
		
	public ArrayList<String> getSolve(){
		return solve;
	}
	
	public void calculate() {
		boolean work = true;
		solve.clear();
		while(work) {
			work = false;
			if(vi != null) {
				if(vf != null) {
					if(a != null) {
						if(t == null) { // vi vf a
							t = (vf-vi)/a;
							solve.add("t = (vf - vi)/(a)");
							solve.add("t = " + "("+ vf + " - " + vi + ")/("+a+")");
							solve.add("t = " + "("+ (vf-vi) + ")/("+a+")");
							solve.add("t = " + t.toString() + " s");
							solve.add(" ");
							work = true;
						}
						if(d == null) { // vi vf a
					        d = (Math.pow(vf,2) - Math.pow(vi,2))/(2*a);
					        solve.add("d = ((vf)² - (vi)²)/(2a)");
					        solve.add("d = " + "(("+vf+")² - ("+vi+")²)/(2("+a+"))");
					        solve.add("d = " + (Math.pow(vf,2) - Math.pow(vi,2)) + "/" + (2*a));
					        solve.add("d = " + d.toString() + " m");
					        solve.add(" ");
					        work = true;
						}
			        }
			        else if(t != null) {
			        	if(a == null) { // vi vf t
					        a = (vf-vi)/t;
					        solve.add("a = (vf - vi)/(t)");
					        solve.add("a = " + "("+vf+" - "+vi+")/"+t);
				            solve.add("a = " + (vf-vi)+"/"+t);
				            solve.add("a = " + a.toString() + " m/s²");
				            solve.add(" ");
					        work = true;
			        	}
			        	if(d == null) { // vi vf t
			        		d = (vi+vf)*t/2;
			        		solve.add("d = (vi + vf)(t)/2");
			        		solve.add("d = " + "("+vi+" + "+vf+")("+t+")/2");
			                solve.add("d = " + (vi+vf)*t + "/2");
			                solve.add("d = " + d.toString() + " m");
			                solve.add(" ");
			        		work = true;
			        	}
			        }
			        else if(d != null) {
			        	if(t == null) { // vi vf d
			        		t = 2*d/(vi+vf);
			        		solve.add("t = (2d)/(vi + vf)");
			        		solve.add("t = " + "((2)("+d+"))/("+vi+" + "+vf+")");
			                solve.add("t = " + (2*d)+"/"+(vi+vf));
			                solve.add("t = " + t.toString() + " s");
			                solve.add(" ");
			        		work = true;
			        	}
			        	if(d == null) { // vi vf d
			        		a = (Math.pow(vf,2) - Math.pow(vi,2))/(2*d);
			        		solve.add("a = (vf² - vi²)/(2d)");
			                solve.add("a = " + "("+vf+"² - "+vi+"²)/((2)("+d+"))");
			                solve.add("a = " + (Math.pow(vf,2) - Math.pow(vi,2))+"/"+2*d);
			                solve.add("a = " + a.toString() + " m/s²");
			                solve.add(" ");
			        		work = true;
			        	}
			        }
				}
		      else if(a != null) {
		        if(t != null) {
		        	if(vf == null) { // vi a t
		        		vf = vi + a*t;
		        		solve.add("vf = vi + (a)(t)");
		        		solve.add("vf = " + vi+" + ("+a+")("+t+")");
		                solve.add("vf = " + vi+" + "+a*t);
		                solve.add("vf = " + vf.toString() + " m/s");
		                solve.add(" ");
		        		work = true;
		        	}
		        	if(d == null) { // vi a t
		        		d = vi*t + .5*a*Math.pow(t,2);
		        		solve.add("d = (vi)(t) + (1/2)(a)(t)²");
		        	    solve.add("d = " + "("+vi+")("+t+") + (1/2)("+a+")("+t+")²");
		                solve.add("d = " + vi*t+" + "+0.5*a*Math.pow(t,2));
		                solve.add("d = " + d.toString() + " m");
		                solve.add(" ");
		        		work = true;
		        	}
		        	System.out.println(solve);
		        }
		        if(d != null) {
		        	if(t == null) { // vi a d
		        		t = 2*d/(vi + Math.sqrt(Math.pow(vi,2) + 2*a*d));
		        		solve.add("t = (2d)/(vi + √(vi² + 2ad))");
		        		solve.add("t = " + "(2)("+d+")/("+vi+" + √("+vi+"² + (2)("+a+")("+d+")))");
		        		solve.add("t = " + "(2)("+d+")/("+vi+" + √(" + Math.pow(vi,2) + " + " + 2*a*d + "))");
		        		solve.add("t = " + "(2)("+d+")/("+vi+" + √(" + (Math.pow(vi,2) + 2*a*d) + "))");
		        		solve.add("t = " + 2*d+"/("+ vi + " + " + Math.sqrt(Math.pow(vi,2) + 2*a*d) + ")");
		                solve.add("t = " + 2*d+"/"+(vi + Math.sqrt(Math.pow(vi,2) + 2*a*d)));
		                solve.add("t = " + t.toString() + " s");
		                solve.add(" ");
		        		work = true;
		        	}
		        	if(vf == null) { //vi a d
		        		vf = Math.sqrt(Math.pow(vi,2) + 2*a*d);
		        		solve.add("vf = √(vi² + 2(a)(d))");
		        		solve.add("vf = " + "√("+vi+"² + (2)("+a+")("+d+"))");
		                solve.add("vf = " + "√("+Math.pow(vi,2)+" + "+2*a*d+")");
		                solve.add("vf = " + "√("+ (Math.pow(vi,2)+2*a*d)+")");
		                solve.add("vf = " + vf.toString() + " m/s");
		                solve.add(" ");
		        		work = true;
		        	}
		        }
		      }
		      else if(t != null && d != null) {
		    	  if(vf == null) { // vi d t
		    		  vf = (2*d/t) - vi;
		    		  solve.add("vf = (2d)/(t) - vi");
		    		  solve.add("vf = " + "(2)("+d+")/("+t+") - "+vi);
		              solve.add("vf = " + (2*d/t)+" - "+vi);
		              solve.add("vf = " + vf.toString() + " m/s");
		              solve.add(" ");
		    		  work = true;
		    	  }
		    	  if(a == null) { // vi d t
		    		  a = (d-vi*t)/(.5*Math.pow(t,2));
		    		  solve.add("a = (2)(d - (vi)(t))/(t²)");
		    		  solve.add("a = " + "(2)("+d+" - ("+vi+")("+t+"))/("+t+"²)");
		              solve.add("a = " + (2)*(d-vi*t)+"/"+(Math.pow(t,2)));
		              solve.add("a = " + a.toString() + " m/s²");
		              solve.add(" ");
		    		  work = true;
		    	  }
		      }
		    }
		    else if (vf != null) {
		      if(a != null) {
		        if(t != null && vi == null) { //vf a t
		          vi = vf - a*t;
		          solve.add("vi = vf - (a)(t)");
		          solve.add("vi = " + vf+" - ("+a+")("+t+")");
		          solve.add("vi = " + vf+" - "+a*t);
		          solve.add("vi = " + vi.toString() + " m/s");
		          solve.add(" ");
		          work = true;
		        }
		        else if(d != null && vi == null) { //vf a d
		           vi = Math.sqrt(Math.pow(vf,2) - 2*a*d); 
		           solve.add("vi = √(vf² - 2ad)");
		           solve.add("vi = " + "√("+vf+"² - (2)("+a+")("+d+"))");
		           solve.add("vi = " + "√("+Math.pow(vf,2)+" - "+2*a*d+")");
		           solve.add("vi = " + vi.toString() + " m/s");
		           solve.add(" ");
		           work = true;
		        }
		      }
		      else if(t != null && d != null && vi == null) { // vf d t
		        vi = (2*d/t) - vf;
		        solve.add("vi = (2)(d)/(t) - vf");
		        solve.add("vi = " + "(2)("+d+")/("+t+") - "+vf);
		        solve.add("vi = " + (2*d/t)+" - "+vf);
		        solve.add("vi = " + vi.toString() + " m/s");
		        solve.add(" ");
		        work = true;
		      }
		    }
		    else if (a != null && t != null && d != null && vi == null) { // a d t
		      vi = (d - .5*a*Math.pow(t,2))/t;
		      solve.add("vi = (d - (1/2)(a)(t)²)/(t)");
		      solve.add("vi = " + "("+d+" - (1/2)("+a+")("+t+")²)/"+t);
		      solve.add("vi = " + "("+d+" - "+.5*a*Math.pow(t,2)+")/"+t);
		      solve.add("vi = " + vi.toString() + " m/s");
		      solve.add(" ");
		      work = true;
		    }
		}
		System.out.println(solve);
		System.out.println("vi"+vi+"vf"+vf+"a"+a+"d"+d+"t"+t);
	}
}
