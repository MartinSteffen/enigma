default:	man
man:	
	@echo ""
	@echo " make all   -  kompiliert die Enigma und erstellt Javadoc Dateien"
	@echo " make clean -  löscht mit make all, make run oder make doc erstellte Dateien"
	@echo " make doc   -  erstellt Javadoc Dateien"
	@echo " make gui   -  kompiliert und startet die GUI"
	@echo " make jar   -  erstellt ein JAR-Archiv"
	@echo " make run   -  kompiliert die Enigma, erstellt Javadok Dateien und startet den Testfile"
	@echo " make test  -  siehe make run"
	@echo ""

all:	doc
	javac enigma/*.java
	javac enigma/exceptions/*.java
	javac enigma/io/*.java
	javac enigma/engine/*.java
	javac enigma/gui/*.java

run:	all
	java enigma.TestFile

gui:	all
	java enigma.StartEnigmaGUI

jar:	all
	jar cvf enigma.jar \
		./enigma/*.class\
		./enigma/data/*.*\
		./enigma/engine/*.class\
		./enigma/exceptions/*.class\
		./enigma/gui/*.class\
		./enigma/io/*.class

test:	run

clean:
	rm -f *~
	rm -f DEADJOE
	rm -f *.core 
	rm -f *.html
	rm -f *.css
	rm -f package-list
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
	rm -f enigma/*.html
	rm -f enigma/io/*~
	rm -f enigma/io/*.class
	rm -f enigma/io/*.DEADJOE
	rm -f enigma/io/*.core
	rm -f enigma/io/*.html
	rm -f enigma/engine/*~
	rm -f enigma/engine/*.class 
	rm -f enigma/engine/DEADJOE 
	rm -f enigma/engine/*.core
	rm -f enigma/engine/*.html
	rm -f enigma/gui/*~
	rm -f enigma/gui/*.class
	rm -f enigma/gui/DEADJOE
	rm -f enigma/gui/*.core
	rm -f enigma/gui/*.html

doc:
	javadoc -subpackages enigma/*.java enigma/engine/*.java enigma/io/*.java enigma/gui/*.java
