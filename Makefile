default:	

all:
	javac enigma/*.java
	javac enigma/exceptions/*.java
	javac enigma/io/*.java
	javac enigma/engine/*.java

run:	all
	java enigma.TestFile

clean:
	rm -f *~
	rm -f DEADJOE
	rm -f *.core 
	rm -f enigma/data/*~
	rm -f enigma/data/*.klartext
	rm -f enigma/data/DEADJOE
	rm -f enigma/data/*.core 
	rm -f enigma/exceptions/*~
	rm -f enigma/exceptions/*.class
	rm -f enigma/exceptions/DEADJOE
	rm -f enigma/exceptions/*.core 
	rm -f enigma/*~
	rm -f enigma/*.class
	rm -f enigma/DEADJOE
	rm -f enigma/*.core 
	rm -f enigma/io/*~
	rm -f enigma/io/*.class
	rm -f enigma/io/*.DEADJOE
	rm -f enigma/io/*.core
	rm -f enigma/engine/*~
	rm -f enigma/engine/*.class 
	rm -f enigma/engine/DEADJOE 
	rm -f enigma/engine/*.core
