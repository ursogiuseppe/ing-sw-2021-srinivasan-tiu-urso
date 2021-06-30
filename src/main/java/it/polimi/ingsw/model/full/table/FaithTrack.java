package it.polimi.ingsw.model.full.table;

import it.polimi.ingsw.model.observerPattern.observables.FaithTrackObservable;
import it.polimi.ingsw.model.utils.GameSettings;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class represents the Faith Track presents in the user dashboard.
 * The object memorizes the state of the Faith Track. The state includes:
 * <ul>
 * <li> The red cross position.
 * <li> The vatican report zones.
 * <li> The bonus victory points in the faith track.
 * <li> The total victory points accumulated by the faith track.
 * </ul>
 * <p>
 * <p>
 * The class is observable and notifies the observers on a change of the state.
 */
public class FaithTrack extends FaithTrackObservable {

    private final Map<Integer, VaticanReport> vaticanReports;
    private final int[] faithTrackVictoryPoints;
    private final Dashboard dashboard;
    private int position;
    private int LorenzoIlMagnificoPosition;
    private int victoryPoints;

    /**
     * The constructor for a FaithTrack object.
     * It initializes the winning points and the user position
     * and load the vatican reports settings and the faith track
     * bonus victory points from the gameSettings object.
     *
     * @param gameSettings the settings for the current game.
     */
    public FaithTrack(GameSettings gameSettings, Dashboard dashboard) {
        this.position = 0;
        this.victoryPoints = 0;
        this.LorenzoIlMagnificoPosition = 0;
        this.vaticanReports = gameSettings.getVaticanReports().stream()
                .collect(Collectors.toMap(v -> v.end, VaticanReport::copy));
        this.faithTrackVictoryPoints = gameSettings.getFaithTrackVictoryPoints();
        this.dashboard = dashboard;
    }

    /**
     * Resets the state of this object to the initial state.
     */
    public void reset() {
        this.position = 0;
        this.victoryPoints = 0;
        vaticanReports.values().forEach(VaticanReport::reset);
        notify(this);
    }

    /**
     * Moves the red cross by pos positions on the faith track, while
     * checking and eventually adding if the cross steps on a bonus cell.
     *
     * @param pos number of positions for the movement.
     */

    public void moveFaithMarker(int pos) {
        for (int i = 1; i <= pos; i++) {
            if (position == GameSettings.FAITH_TRACK_LENGTH - 1) {
                updateVictoryPoints();
                notify(this);
                return;
            }
            position++;
        }
        updateVictoryPoints();
        notify(this);
    }

    /**
     * To be called when a player reaches a vatican checkpoint cell.
     * This methods checks if the cross has reached the start of
     * the vatican report zone described by the checkpoint that is
     * passes to the method. In case it has, it will add the points
     * to the winningPoints and set the vaticanReport to achieved,
     * otherwise it will set the vatican report to missed.
     *
     * @param vaticanReportEnd checkpoint of the vatican report zone
     *                         to be checked.
     */
    public void checkVaticanVictoryPoints(int vaticanReportEnd) {
        VaticanReport currentVaticanReport;
        for (int i = 0; i <= vaticanReportEnd; i++) {
            currentVaticanReport = vaticanReports.get(i);
            if (currentVaticanReport != null) {
                if (position < currentVaticanReport.start) {
                    currentVaticanReport.miss();
                } else if (!currentVaticanReport.isMissed()) {
                    currentVaticanReport.achieve();
                }
            }
        }
        updateVictoryPoints();
        notify(this);
    }

    /**
     * Getter for the position
     *
     * @return the current red cross position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Getter for the victoryPoints
     *
     * @return the current victoryPoints
     */
    public void updateVictoryPoints() {
        this.victoryPoints = 0;
        for (int i = 0; i <= position; i++) {
            victoryPoints += faithTrackVictoryPoints[i];
        }
        victoryPoints += vaticanReports.values()
                .stream()
                .map(v -> v.isAchieved() ? v.getVictoryPoints() : 0)
                .reduce(0, Integer::sum);
    }

    public int getVictoryPoints() {
        return victoryPoints;
    }

    /**
     * Getter for vaticanReports
     *
     * @return list of vaticanReports
     */
    public Map<Integer, VaticanReport> getVaticanReports() {
        return vaticanReports;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    /**
     * Move's Lorenzo faith marker
     *
     * @param pos the new position
     */
    public void moveLorenzoIlMagnificoMarker(int pos) {
        for (int i = 1; i <= pos; i++) {
            if (LorenzoIlMagnificoPosition == GameSettings.FAITH_TRACK_LENGTH - 1) {
                notify(this);
                return;
            }
            LorenzoIlMagnificoPosition++;
        }
        notify(this);
    }

    public int getLorenzoIlMagnificoPosition() {
        return LorenzoIlMagnificoPosition;
    }
}
