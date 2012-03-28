ifeq ($(origin JAVA_HOME), undefined)
  JAVA_HOME=/usr
endif

ifeq ($(origin NETLOGO), undefined)
  NETLOGO=../..
endif

ifneq (,$(findstring CYGWIN,$(shell uname -s)))
  COLON=\;
  JAVA_HOME := `cygpath -up "$(JAVA_HOME)"`
else
  COLON=:
endif

JAVAC=$(JAVA_HOME)/bin/javac
SRCS=$(wildcard src/*.java)

sample.jar sample.jar.pack.gz: $(SRCS) manifest.txt Makefile $(JARS)
	mkdir -p classes
	$(JAVAC) -g -deprecation -Xlint:all -Xlint:-serial -Xlint:-path -encoding us-ascii -source 1.5 -target 1.5 -classpath $(NETLOGO)/NetLogoLite.jar$(COLON)$(JARSPATH) -d classes $(SRCS)
	jar cmf manifest.txt sample.jar -C classes .
	pack200 --modification-time=latest --effort=9 --strip-debug --no-keep-file-order --unknown-attribute=strip sample.jar.pack.gz sample.jar

sample.zip: sample.jar
	rm -rf sample
	mkdir sample
	cp -rp sample.jar sample.jar.pack.gz README.md Makefile src manifest.txt sample
	zip -rv sample.zip sample
	rm -rf sample
