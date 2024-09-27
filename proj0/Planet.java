public class Planet {
    private static double G=6.67e-11;
    public double xxPos,yyPos,xxVel,yyVel,mass;
    public String imgFileName;
    public Planet(double xP,double yP,double xV,double yV,double m,String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }
    public Planet(Planet p){
        this.imgFileName=p.imgFileName;
        this.xxPos=p.xxPos;
        this.yyPos=p.yyPos;
        this.mass=p.mass;
        this.xxVel=p.xxVel;
        this.yyVel=p.yyVel;
    }
    public double calcDistance(Planet p){
        return Math.sqrt((this.xxPos-p.xxPos)*(this.xxPos-p.xxPos)+(this.yyPos-p.yyPos)*(this.yyPos-p.yyPos));
    }
    public double calcForceExertedBy(Planet p){
        return (G*this.mass*p.mass)/(calcDistance(p)*calcDistance(p));
    }
    public double calcForceExertedByX(Planet p){
        return calcForceExertedBy(p)*(p.xxPos-this.xxPos)/calcDistance(p);
    }
    public double calcForceExertedByY(Planet p){
        return calcForceExertedBy(p)*(p.yyPos-this.yyPos)/calcDistance(p);
    }
    public double calcNetForceExertedByX(Planet[] p){
        double Fx=0;
        for(int temp=0;temp<p.length;temp++){
            if(p[temp].equals(this)){
                continue;
            }
            else {
                Fx = Fx + calcForceExertedByX(p[temp]);
            }
        }
        return Fx;
    }
    public double calcNetForceExertedByY(Planet[] p){
        double Fy=0;
        for(int temp=0;temp<p.length;temp++){
            if(p[temp].equals(this)){
                continue;
            }
            else{
                Fy=Fy+calcForceExertedByY(p[temp]);
            }
        }
        return Fy;
    }
    public void update(double dt,double fX,double fY){
        double aX,aY;
        aX=fX/this.mass;
        aY=fY/this.mass;
        xxVel=xxVel+aX*dt;
        yyVel=yyVel+aY*dt;
        xxPos=xxPos+xxVel*dt;
        yyPos=yyPos+yyVel*dt;
    }
    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos,"images/"+imgFileName);
    }
}
