#!/bin/sh

javac -cp src -d bin/ src/fr/esisar/cs312/crypto/* src/fr/esisar/cs312/crypto/algos/*
jar -cvfe Main.jar fr.esisar.cs312.crypto.Main -C bin .

if [ "$#" -eq  "0" ]; then
    exit 1
else
    java -jar Main.jar $@
fi