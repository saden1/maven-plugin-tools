package org.apache.maven.tools.plugin.javadoc;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import com.sun.tools.doclets.Taglet;
import org.apache.maven.tools.plugin.extractor.java.JavaMojoAnnotation;

import java.util.Map;

/**
 * The <tt>@requiresDependencyCollection</tt> tag is used to specify the required dependencies in the specified scope
 * and has parameter.
 * <br/>
 * The following is a sample declaration:
 * <pre>
 * &#x2f;&#x2a;&#x2a;
 * &#x20;&#x2a; Dummy Mojo.
 * &#x20;&#x2a;
 * &#x20;&#x2a; &#64;requiresDependencyCollection &lt;requiredScope&gt;
 * &#x20;&#x2a; ...
 * &#x20;&#x2a;&#x2f;
 * public class MyMojo extends AbstractMojo{}
 * </pre>
 * To use it, calling the <code>Javadoc</code> tool with the following:
 * <pre>
 * javadoc ... -taglet 'org.apache.maven.tools.plugin.javadoc.MojoRequiresDependencyCollectionTypeTaglet'
 * </pre>
 * <b>Note</b>: This taglet is similar to call the <code>Javadoc</code> tool with the following:
 * <pre>
 * javadoc ... -tag 'requiresDependencyCollection:t:Requires the collection of the dependencies in this specified scope:'
 * </pre>
 *
 * @see <a href="package-summary.html#package_description">package-summary.html</a>
 *
 * @author Kristian Rosenvold
 * @version $Id$
 */
public class MojoRequiresDependencyCollectionTypeTaglet
    extends AbstractMojoTypeTaglet
{
    /** The Javadoc annotation */
    private static final String NAME = JavaMojoAnnotation.REQUIRES_DEPENDENCY_COLLECTION;

    /** The Javadoc text which will be added to the generated page. */
    protected static final String HEADER = "Collects the dependencies in this specified scope";

    /**
     * @return By default, return the string defined in {@linkplain #HEADER}.
     * @see AbstractMojoTaglet#getHeader()
     * @see #HEADER
     */
    public String getHeader()
    {
        return HEADER;
    }

    /**
     * @return <code>"*"</code> since <code>@requiresDependencyCollection</code> has value.
     * @see AbstractMojoTaglet#getAllowedValue()
     */
    public String getAllowedValue()
    {
        return "*";
    }

    /**
     * @return <code>null</code> since <code>@requiresDependencyCollection</code> has no parameter.
     * @see AbstractMojoTaglet#getAllowedParameterNames()
     */
    public String[] getAllowedParameterNames()
    {
        return null;
    }

    /**
     * @return By default, return the name of this taglet.
     * @see com.sun.tools.doclets.Taglet#getName()
     * @see org.apache.maven.tools.plugin.javadoc.MojoRequiresDependencyCollectionTypeTaglet#NAME
     */
    public String getName()
    {
        return NAME;
    }

    /**
     * Register this Taglet.
     *
     * @param tagletMap the map to register this tag to.
     */
    public static void register( Map<String, Taglet> tagletMap )
    {
        MojoRequiresDependencyCollectionTypeTaglet tag = new MojoRequiresDependencyCollectionTypeTaglet();
        Taglet t = tagletMap.get( tag.getName() );
        if ( t != null )
        {
            tagletMap.remove( tag.getName() );
        }
        tagletMap.put( tag.getName(), tag );
    }
}