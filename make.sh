#!/bin/sh

javac -cp src -d bin/ src/fr/esisar/cs312/crypto/*
jar -v -c -e fr.esisar.cs312.crypto.Main -f Main.jar -C bin .
java -jar Main.jar $@