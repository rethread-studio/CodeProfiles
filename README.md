# CodeProfiles

This repository wraps into a Maven project an original piece of code and artwork by  [W. Bradford Paley](http://wbradfordpaley.com/live/).

The original source code can be found [here](http://artport.whitney.org/commissions/codedoc/Paley/code.html), hosted by the by the [Whitney Museum's portal to Internet art](http://whitney.org/Exhibitions/Artport). It was written on August 9-15 2002 for CODeDOC; commissioned by Christiane Paul, Curator at the Whitney Museum of American Art, NY USA.

More than 14 years after its creation, we were very much inspired by this very nice and cool art work. Putting it on github, we wanted to, hopefully, increase its visibility.

You can watch a [video excerpt](https://github.com/DIVERSIFY-project/CodeProfiles/blob/master/CodeProfiles-short.mp4). It reads like this:
- the green text in the background is the whole source code to run this piece of software art
- the green lines show how the code executes (we can see loops, calls to other parts of the program, etc.)
- the white lines show the order in which the code was written by the author
- the orange lines show how a human reads the code, from top to bottom

## CodeProfiles restored with Maven

To run the CodeProfiles artwork, run the following commands. Requirements: [Maven](https://maven.apache.org/) and Java 11 or higher.

```
git clone https://github.com/DIVERSIFY-project/CodeProfiles.git
cd CodeProfiles
mvn clean install
java -jar target/Applet.jar 
```

You can adjust the size of the frame by passing them as arguments. 

```
java -jar target/Applet.jar -w 1280 -h 720
```

## CodeProfiles restored with Webassembly and CheerpJ

We have released a version of CodeProfiles that uses [CheerpJ](https://cheerpj.com/) to run the original Java applet compiled to Webassembly:
```
python -m http.server 8080
go to `http://localhost:8080/cheerp.html`
```
To ensure a good resolution, create the applet html element as big as possible, and adjust the body wrapper with a `zoom` < 1. The resolution is managed by the CSS engine of the browser. The larger the applet, the more time the piece needs to load.
