# Gestor de Archivos (File Manager)

## Overview
A Java console application that demonstrates various design patterns including Factory, Singleton, and Command patterns through a file management system. The application simulates file operations like creating, deleting, copying, and renaming files, along with search functionality and operation history tracking.

## Project Architecture

### Languages & Tools
- **Java 19** (GraalVM CE 22.3.1)
- **Apache Ant** for build management
- **NetBeans** project structure

### Build System
The project uses Apache Ant with a NetBeans configuration:
- `build.xml` - Main Ant build file
- `nbproject/` - NetBeans project configuration
- Build target: Java 19 (adjusted from original Java 21)

### Project Structure
```
src/gestordearchivos/
├── acciones/          # Action classes (Command pattern)
├── factory/           # Factory classes for creating actions
├── model/             # File model classes (Archivo, Imagen, Video, etc.)
├── repositorio/       # File repository management
├── service/           # Business logic services
├── so/               # Operating System simulation
├── EntryPoint.java   # Main entry point
└── GestorArchivos.java # Main file manager (Singleton)
```

### Key Design Patterns Demonstrated
1. **Singleton Pattern**: `GestorArchivos` class
2. **Factory Pattern**: Action creation through `FabricaAccion` classes
3. **Command Pattern**: File operations through `Accion` classes
4. **Repository Pattern**: File management through `RepositorioArchivos`

### Core Features
- File creation (Images, Documents, Videos)
- File operations (Copy, Delete, Rename)
- File search by type, name, or date
- Operation history tracking
- Storage space management simulation

## Running the Application

### Building
```bash
ant clean compile jar
```

### Running
The application can be run in two ways:
1. **Direct execution**: `java -cp build/classes gestordearchivos.EntryPoint`
2. **JAR execution**: `java -jar dist/GestorDeArchivos.jar`

The workflow is configured to run the JAR version automatically.

### Sample Output
The application demonstrates:
- Creating sample files (photo, document, video)
- Performing file operations (delete, copy, rename)
- Searching files by type
- Displaying operation history

## Development Notes

### Environment Setup
- Java 19 with GraalVM is installed
- Apache Ant build tool is configured
- Project originally targeted Java 21 but adjusted for compatibility

### Recent Changes
- **2025-09-29**: Initial project import and setup
- Adjusted Java target version from 21 to 19 for compatibility
- Configured workflow for console output
- Set up Apache Ant build system

## User Preferences
- Project maintained as a console application (not web-based)
- Preserves original NetBeans project structure
- Uses existing Java design patterns demonstration approach