package fr.brouillard.oss.jgitver;

import com.google.common.base.Preconditions;
import org.apache.maven.model.Model;
import org.apache.maven.model.Parent;
import org.apache.maven.project.MavenProject;

/**
 * Wrapper for a maven project/dependency identified by a groupId/artifactId/version.
 */
public class GAV {
    private String groupId;
    private String artifactId;
    private String version;

    /**
     * Builds an immutable GAV object.
     *
     * @param groupId    the groupId of the maven object
     * @param artifactId the artifactId of the maven object
     * @param version    the version of the maven object
     */
    public GAV(String groupId, String artifactId, String version) {
        Preconditions.checkNotNull(groupId);
        Preconditions.checkNotNull(artifactId);
        Preconditions.checkNotNull(version);
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
    }



    public String getGroupId() {
        return groupId;
    }


    public String getArtifactId() {
        return artifactId;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        GAV gav = (GAV) o;

        if (!groupId.equals(gav.groupId))
            return false;
        if (!artifactId.equals(gav.artifactId))
            return false;
        return version.equals(gav.version);
    }

    @Override
    public int hashCode() {
        int result = groupId.hashCode();
        result = 31 * result + artifactId.hashCode();
        result = 31 * result + version.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s::%s::%s", groupId, artifactId, version);
    }


}