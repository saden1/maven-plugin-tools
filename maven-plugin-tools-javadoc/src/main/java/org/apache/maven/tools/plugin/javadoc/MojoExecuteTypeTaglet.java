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

import java.util.Map;

import org.apache.maven.tools.plugin.extractor.java.JavaMojoAnnotation;

import com.sun.tools.doclets.Taglet;

/**
 * The <tt>@execute</tt> tag is used to reference the invocation way of the Mojo and has parameters.
 * <br/>
 * The following is a sample declaration:
 * <pre>
 * &#x2f;&#x2a;&#x2a;
 * &#x20;&#x2a; Dummy Mojo.
 * &#x20;&#x2a;
 * &#x20;&#x2a; &#64;execute phase="..." lifecycle="..."
 * &#x20;&#x2a; &lt;OR&gt;
 * &#x20;&#x2a; &#64;execute phase="..."
 * &#x20;&#x2a; &lt;OR&gt;
 * &#x20;&#x2a; &#64;execute goal="..."
 * &#x20;&#x2a; ...
 * &#x20;&#x2a;&#x2f;
 * public class MyMojo extends AbstractMojo{}
 * </pre>
 * To use it, calling the <code>Javadoc</code> tool with the following:
 * <pre>
 * javadoc ... -taglet 'org.apache.maven.tools.plugin.javadoc.MojoExecuteTypeTaglet'
 * </pre>
 *
 * @see <a href="package-summary.html#package_description">package-summary.html</a>
 *
 * @author <a href="mailto:vincent.siveton@gmail.com">Vincent Siveton</a>
 * @version $Id$
 */
public class MojoExecuteTypeTaglet
    extends AbstractMojoTypeTaglet
{
    /** The Javadoc annotation */
    private static final String NAME = JavaMojoAnnotation.EXECUTE;

    private static final String[] PARAMETERS_NAME = {
        JavaMojoAnnotation.EXECUTE_PHASE,
        JavaMojoAnnotation.EXECUTE_LIFECYCLE,
        JavaMojoAnnotation.EXECUTE_GOAL };

    /** The Javadoc text which will be added to the generated page. */
    protected static final String HEADER = "Is defined to be executed in";

    /**
     * @return By default, return the string defined in {@linkplain #HEADER}.
     * @see org.apache.maven.tools.plugin.javadoc.AbstractMojoTaglet#getHeader()
     * @see #HEADER
     */
    public String getHeader()
    {
        return HEADER;
    }

    /**
     * @return <code>null</code> since <code>@execute</code> has no value.
     * @see org.apache.maven.tools.plugin.javadoc.AbstractMojoTaglet#getAllowedValue()
     */
    public String getAllowedValue()
    {
        return null;
    }

    /**
     * @return <code>MojoExecuteTypeTaglet#PARAMETERS_NAME</code> since <code>@execute</code> has parameters.
     * @see org.apache.maven.tools.plugin.javadoc.AbstractMojoTaglet#getAllowedParameterNames()
     * @see #PARAMETERS_NAME
     */
    public String[] getAllowedParameterNames()
    {
        return PARAMETERS_NAME;
    }

    /**
     * @return By default, return the name of this taglet.
     * @see com.sun.tools.doclets.Taglet#getName()
     * @see MojoExecuteTypeTaglet#NAME
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
        MojoExecuteTypeTaglet tag = new MojoExecuteTypeTaglet();
        Taglet t = tagletMap.get( tag.getName() );
        if ( t != null )
        {
            tagletMap.remove( tag.getName() );
        }
        tagletMap.put( tag.getName(), tag );
    }
}
