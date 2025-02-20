# Kafka Connect File Pulse

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/streamthoughts/kafka-connect-file-pulse/blob/master/LICENSE)
[![CircleCI](https://circleci.com/gh/streamthoughts/kafka-connect-file-pulse.svg?style=svg)](https://circleci.com/gh/streamthoughts/kafka-connect-file-pulse)

<p align="center">
  <img width="400" height="400" src="https://github.com/streamthoughts/kafka-connect-file-pulse/raw/master/site/static/images/streamthoughts-connect-file-pule-logo.png">
</p>

**Connect FilePulse** is a polyvalent, scalable and reliable, 
[Kafka Connector](http://kafka.apache.org/documentation.html#connect) that makes it easy to parse, transform and stream any file, in any format, into Apache Kafka™.
Connect FilePulse*

## Motivation

In organizations, data is frequently exported, shared and integrated from legacy systems through the use of
files in a wide variety of formats (e.g. CSV, XML, JSON, Avro, etc.). Dealing with all of these formats can
quickly become a real challenge for enterprise that usually end up with a complex and hard
to maintain data integration mess.
	
	
A modern approach consists in building a scalable data streaming platform as a central nervous
system to decouple applications from each other. **Apache Kafka™** is one of the most widely
used technologies to build such a system. The Apache Kafka project packs with Kafka Connect a distributed,
fault tolerant and scalable framework for connecting Kafka with external systems.

The **Connect File Pulse** project aims to provide an easy-to-use solution, based on Kafka Connect,
for streaming any type of data file with the Apache Kafka™ platform.


Connect File Pulse is inspired by the features provided by **Elasticsearch** and **Logstash**.

## Key Features Overview

Connect FilePulse provides a set of built-in features for streaming local files into Kafka. This includes, among other things:

* Support for recursive scanning of local directories.
* Reading and writing files into Kafka line by line.
* Support multiple input file formats (e.g: CSV, Avro, XML).
* Parsing and transforming data using built-in or custom processing filters.
* Error handler definition
* Monitoring files while they are being written into Kafka
* Support plugeable strategies to cleanup up completed files
* Etc.

## How to get started ?

The best way to learn Connect File Pulse is to follow the step by step [Getting Started](https://streamthoughts.github.io/kafka-connect-file-pulse/docs/getting-started/).

If you want to read about using Connect File Pulse, the full documentation can be found [here](https://streamthoughts.github.io/kafka-connect-file-pulse/)

## Show your support

Please ⭐ this repository if this project helped you!

## Contributions

Any feedback, bug reports and PRs are greatly appreciated! See our [guideline](./CONTRIBUTING.md)

## Licence

Copyright 2019-2020 StreamThoughts.

Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements. See the NOTICE file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License