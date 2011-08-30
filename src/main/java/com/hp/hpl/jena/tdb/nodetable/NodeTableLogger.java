/*
 * (c) Copyright 2009 Hewlett-Packard Development Company, LP
 * (c) Copyright 2011 Epimorphics Ltd.
 * All rights reserved.
 * [See end of file]
 */

package com.hp.hpl.jena.tdb.nodetable;

import java.util.Iterator ;

import org.openjena.atlas.lib.Pair ;
import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;

import com.hp.hpl.jena.graph.Node ;
import com.hp.hpl.jena.tdb.store.NodeId ;

public class NodeTableLogger implements NodeTable
{
    private static Logger defaultLogger = LoggerFactory.getLogger(NodeTable.class) ; 
    private final Logger log ;
    private final String label  ;

    private final NodeTable nodeTable ;
    
    public NodeTableLogger(String label, NodeTable nodeTable)
    {
        this.nodeTable = nodeTable ;
        this.label = label ;
        log = defaultLogger ;
    }
    
    @Override
    public NodeId getAllocateNodeId(Node node)
    {
        //info("getAllocateNodeId("+node+") =>") ;
        NodeId nId = nodeTable.getAllocateNodeId(node) ;
        info("getAllocateNodeId("+node+") => "+nId) ;
        return nId ;
    }

    @Override
    public NodeId getNodeIdForNode(Node node)
    {
        //info("getNodeIdForNode("+node+") =>") ;
        NodeId nId = nodeTable.getNodeIdForNode(node) ;
        info("getNodeIdForNode("+node+") => "+nId) ;
        return nId ;
    }

    @Override
    public Node getNodeForNodeId(NodeId id)
    {
        //info("getNodeForNodeId("+id+") =>") ;
        Node n = nodeTable.getNodeForNodeId(id) ;
        info("getNodeForNodeId("+id+") => "+n) ;
        return n ;
    }
    
    @Override
    public NodeId allocOffset()
    {
        NodeId nodeId = nodeTable.allocOffset() ;
        info("allocOffset() => "+nodeId) ;
        return nodeId ;
    }
    
    @Override
    public Iterator<Pair<NodeId, Node>> all()
    {
        info("all()") ;
        return nodeTable.all();
    }

    @Override
    public boolean isEmpty()
    {
        boolean b = nodeTable.isEmpty() ; 
        info("isEmpty() => "+b) ;
        return b ;
    }

    @Override
    public void sync()
    {
        info("sync()") ;
        nodeTable.sync() ; 
    } 

    @Override
    public void close()
    {
        info("close()") ; ;
        nodeTable.close() ;
    }

    private void info(String string)
    {
        if ( label != null )
            string = label+": "+string ;
        log.info(string) ; 
    }
}

/*
 * (c) Copyright 2009 Hewlett-Packard Development Company, LP
 * (c) Copyright 2011 Epimorphics Ltd.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */