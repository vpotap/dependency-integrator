package org.di.api.impl

import org.di.api.SourceRepository
import org.di.engine.BuildRunner
import org.di.graph.Graph
import org.di.graph.visualization.GraphVizGenerator


public class Main {
    public static void main(String... args) {
        SourceRepository repository = new CarfaxLibSourceRepository(localDir: new File("D:/hackathon"));
       // repository.downloadAll()
//        Graph g = new Graph(repository)
//        g.initRank()
//        g.cycles.each {
//            println it
//        }
//        def gv = new GraphVizGenerator(graph: g)
//                gv.generate()
//        gv.reveal()
        def projects = repository.init()
        projects.each {
            println it.version
        }

//        long start = System.currentTimeMillis()
//        BuildRunner br = new BuildRunner(projectSources: projects[0..10])
//        br.start(5)
//        def results = br.completeBuildRecords
//        long stop = System.currentTimeMillis()
//        results.each {
//            println it.projectSource.name +" "+it.result
//        }
//
//        println "Total time (ms): "+(stop - start)


    }





}
