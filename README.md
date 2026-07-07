# E-Learning System Ontology Development

## Project Overview
This project involves the design and implementation of a comprehensive E-Learning System Ontology using Semantic Web technologies. The knowledge graph structurally models academic institutions, users (students and instructors), learning materials, and evaluation processes. The architecture separates the schema (TBox) and data (ABox) layers to ensure a scalable and logically consistent system capable of complex SPARQL querying and reasoning.

## Repository Contents
* **`elearning-tbox.ttl`**: The ontology schema defining classes, object properties, and data properties.
* **`elearning-abox.ttl`**: The populated knowledge graph (demo dataset) containing individuals and instances.
* **`shacl-shapes.ttl`**: Validation constraints ensuring data integrity (e.g., cardinality, value ranges).
* **`src/ELearningDataGenerator.java`**: Custom Java application used for synthetic data generation.
* **`myDocumentation/`**: HTML documentation of the ontology generated via WIDOCO.

## Data Acquisition & Synthetic Data Generation
To ensure the system can be scaled to handle thousands of records, we developed a custom automated data generation pipeline rather than relying on unstructured external datasets. 
We utilized the **Java Faker** library to programmatically generate realistic, structured datasets for students and courses. The `ELearningDataGenerator.java` script ensures that all generated data strictly conforms to the XSD data types required by our OWL ontology. The `elearning-abox.ttl` file contains a curated subset of this data tailored for presentation and proof-of-concept testing.

## Live Documentation (WIDOCO)
The comprehensive documentation of the classes, properties, and data models used in this ontology can be viewed here:
👉 **[Click here to view the WIDOCO Documentation](https://alialiyev0.github.io/E-Learning-System-Ontology/myDocumentation/index-en.html)**

## Setup and Usage Instructions
1. Download or clone this repository to your local machine.
2. Open [Protégé](https://protege.stanford.edu/).
3. Go to `File > Open` and select the `elearning-tbox.ttl` file.
4. The ABox (`elearning-abox.ttl`) and SHACL constraints are designed to work in conjunction with the TBox.
5. To test logical inferences, navigate to the `Reasoner` menu, select `HermiT` or `Pellet`, and click `Start reasoner`.
6. Navigate to the `SPARQL Query` tab in Protégé to execute queries against the populated knowledge graph.
