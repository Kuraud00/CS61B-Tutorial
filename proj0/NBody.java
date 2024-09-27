public class NBody{
    public static double readRadius(String Filepath){
        In in = new In (Filepath);
        int temp=in.readInt();
        return in.readDouble();
    }
    public static Planet[] readPlanets(String Filepath){
        In in = new In (Filepath);
        int count=in.readInt();
        Planet[] p = new Planet[count];
        double temp=in.readDouble();
        for(int i=0;i<count;i++){
            p[i]=new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        return p;
    }
    public static void main(String[] args){
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        double r=readRadius(filename);
        Planet[] p=readPlanets(filename);
        StdDraw.setScale(-r, r);
        In in = new In (filename);
        StdDraw.enableDoubleBuffering();
        int count=in.readInt();
        for(long time=0;time<T;time+=dt){
            double[] xForces=new double[count];
            double[] yForces=new double[count];
            for(int temp=0;temp<count;temp++){
                xForces[temp]=p[temp].calcNetForceExertedByX(p);
                yForces[temp]=p[temp].calcNetForceExertedByY(p);
            }
            StdDraw.picture(0,0,"images/starfield.jpg");
            for(int temp=0;temp<count;temp++){
                p[temp].update(dt,xForces[temp],yForces[temp]);
                p[temp].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        StdOut.printf("%d\n", p.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < p.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    p[i].xxPos, p[i].yyPos, p[i].xxVel,
                    p[i].yyVel, p[i].mass, p[i].imgFileName);
        }
    }
}